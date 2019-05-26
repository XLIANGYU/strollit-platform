/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.constance.BaseConstance;
import com.icefrog.strollit.baseframework.domain.UserDto;
import com.icefrog.strollit.baseframework.util.HttpClientUtil;
import com.icefrog.strollit.baseframework.util.HttpMethod;
import net.sf.json.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/***
 * BaseController
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public abstract class BaseController extends BaseServer implements IController {
    
    /***
     * 获取当前登录用户id, 可能null
     * @return user id
     */
    public String getUserId(){
        JSONObject userInfo = this.getUserInfo();
        return userInfo.getString("id");
    }
    
    private JSONObject getUserInfo(){
        return JSONObject.fromObject(this.getRequest().getAttribute(BaseConstance.UserInfoHeader));
    }
    
    /***
     * 获取当前登录的用户基础信息。 当前request 中若不包含登录用户信息则返回null
     * @param request HttpServletRequest request
     * @return UserDto
     */
    @Override
    public UserDto getUser(HttpServletRequest request) {
        return null;
    }
    
    protected HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest();
    }
    
    protected HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getResponse();
    }
    
    /**
     * 发送一个http请求 默认使用GET请求方式
     * @return
     */
    protected String callApi(String url){
        return HttpClientUtil.doGet(url, null);
    }
    
    /**
     * 发送一个http请求 默认使用GET请求方式 并指定请求参数
     * @return
     */
    protected String callApi(String url,final Map<String, String> params){
        return HttpClientUtil.doGet(url, params);
    }
    
    /**
     * 发送一个http请求 并指定请求方式
     * @return
     */
    protected String callApi(String url,final HttpMethod requestMethod){
        if(requestMethod == HttpMethod.GET){
            return HttpClientUtil.doGet(url, null);
        }else if(requestMethod == HttpMethod.POST){
            return HttpClientUtil.doPost(url, null);
        }else{
            throw new RuntimeException("Unsupported request method");
        }
    }
    
    /**
     * 发送一个http请求 指定请求方式与参数信息
     * @return
     */
    protected String callApi(String url,final HttpMethod requestMethod, final Map<String, String> params) {
        if(params == null){
            throw new RuntimeException("参数map为null");
        }
        if(requestMethod == HttpMethod.GET){
            return HttpClientUtil.doGet(url, params);
        }else if(requestMethod == HttpMethod.POST){
            return HttpClientUtil.doPost(url, params);
        }else{
            throw new RuntimeException("Unsupported request method");
        }
    }
}
