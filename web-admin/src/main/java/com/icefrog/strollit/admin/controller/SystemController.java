/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.controller;

import com.icefrog.strollit.admin.client.UserFeignClient;
import com.icefrog.strollit.admin.util.Constance;
import com.icefrog.strollit.admin.util.ImageCodeBuilder;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.redis.JedisService;
import com.icefrog.strollit.baseframework.util.DateUtil;
import com.icefrog.strollit.baseframework.util.PasswdUtils;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import com.icefrog.strollit.user.dto.UserDto;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController extends ApiBaseController {

    @Autowired
    private JedisService jedisService;
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    @RequestMapping("/index")
    public String toIndex(){
        return "home/index";
    }
    
    @RequestMapping("/toMainPage")
    public String toMainPage(){
        return "home/main";
    }
    
    @RequestMapping("login")
    public String login(){
        return "login";
    }

    /***
     * 生成一个验证码
     * @param response HttpServletResponse
     */
    @RequestMapping("/imagesCode")
    public void imagesCode( HttpServletResponse response) throws IOException {
        OutputStream os = response.getOutputStream();
        Map<String,Object> map = ImageCodeBuilder.getImageCode(60, 20, os);
        String code = map.get("strEnsure").toString().toLowerCase();
        String captchaRdsKey = Constance.AppName + ":CAPTCHA:" + code;
        jedisService.set(captchaRdsKey, code, "NX", "EX", 60);
        try {
            ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @RequestMapping("/doLogin")
    @ResponseBody
    public ApiResult<Map<String, Object>> doLogin(HttpServletRequest request) throws UnsupportedEncodingException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identify = request.getParameter("identify");
        // 双重验证(前后台验证数据合法性)
        if(StringUtils.isBlank(username)){
            return error("请输入用户名!");
        }
        if(StringUtils.isBlank(password)){
            return error("请输入密码!");
        }
        if(StringUtils.isBlank(identify)){
            return error("请输入验证码!");
        }
        
        // 检查验证码是否过期
        String captchaRdsKey = Constance.AppName + ":CAPTCHA:" + identify;
        if(StringUtils.isBlank(jedisService.get(captchaRdsKey))){
            return error("验证码错误或已失效!");
        }
    
        ApiResult<UserDto> userDtoApiResult = userFeignClient.loginWithQueryUser(username);
        if(userDtoApiResult == null || userDtoApiResult.isError()){
            return error("登录失败, 用户服务不可用!");
        }
        UserDto userDto = userDtoApiResult.getData();
        if(userDto == null){
            return error("用户不存在!");
        }
        if(userDto.getIsDestory().intValue() == 1){
            return error("抱歉, 你已被注销,无法正常使用此账号!");
        }
        if(userDto.getIsDisable().intValue() == 1){
            return error("抱歉, 你已被禁用, 请联系管理员!");
        }
        // 检查密码
        if(!PasswdUtils.verification(password, userDto.getPasswd(), userDto.getSalt())){
            return error("密码不正确!");
        }
        
        // 登录成功
        
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("callback", "/system/index");
        rspData.put("userInfo", Base64.encodeBase64String(JSONObject.fromObject(userDto).toString().getBytes("utf-8")));
    
        return new ApiResult<Map<String, Object>>().success(rspData);
    }

}