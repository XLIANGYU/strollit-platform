
package com.icefrog.strollit.admin.controller;

import com.icefrog.strollit.admin.util.ImageCodeBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/system")
public class SystemController {

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
    
    
    String simpleCaptcha = "simpleCaptcha";
    String codeTime = "codeTime";
    /***
     * 生成一个验证码
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @RequestMapping("/imagesCode")
    public void imagesCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        OutputStream os = response.getOutputStream();
        Map<String,Object> map = ImageCodeBuilder.getImageCode(60, 20, os);
        session.setAttribute(simpleCaptcha, map.get("strEnsure").toString().toLowerCase());
        session.setAttribute(codeTime,new Date().getTime());
        try {
            ImageIO.write((BufferedImage) map.get("image"), "JPEG", os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}