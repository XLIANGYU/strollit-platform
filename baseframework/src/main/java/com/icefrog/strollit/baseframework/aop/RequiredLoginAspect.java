package com.icefrog.strollit.baseframework.aop;


import com.icefrog.strollit.baseframework.annotation.RequiredLogin;
import com.icefrog.strollit.baseframework.constance.BaseConstance;
import com.icefrog.strollit.baseframework.util.Base64Util;
import com.icefrog.strollit.baseframework.util.RspUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/***
 * 检查当前请求上下文中是否具备登录信息。 具体登录信息验证参阅 this.#tryFetchUserId
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
@Component
@Aspect
@Slf4j
public class RequiredLoginAspect {

    /**
     * 环绕通知,校验登录信息
     */
    @Around("@annotation(com.icefrog.strollit.baseframework.annotation.RequiredLogin)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        
        log.info("成功拦截");
        
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();

        String methodName = pjp.getSignature().getName();
        Method method = pjp.getTarget().getClass().getMethod(methodName, ((MethodSignature) pjp.getSignature()).getParameterTypes());
        RequiredLogin requiredLoginAnnotation = method.getAnnotation(RequiredLogin.class);

        if (requiredLoginAnnotation.required()) {
            String userId = tryFetchUserId(request);
            if(StringUtils.isBlank(userId)){
                RspUtils.responseErrorApiResultJson("Please login first!", null, response);
                return null;
            }
            request.setAttribute(BaseConstance.LOGIN_USER_ID, Base64Util.decodeString(userId));
        }
        return pjp.proceed();
    }
    
    /***
     * try fetch user id, maybe return null
     * 1. request.getHeader
     * 2. request.getParameter
     * 3. request.getCookies
     * @param request HttpServletRequest
     * @return user id, see {BaseConstance.LOGIN_USER_ID}
     */
    private String tryFetchUserId(HttpServletRequest request){
        // try fetch user id with request header
        if(StringUtils.isNotBlank(request.getHeader(BaseConstance.LOGIN_USER_ID))){
            return request.getHeader(BaseConstance.LOGIN_USER_ID);
        }
        // try fetch user id with get/post's parameter
        if(StringUtils.isNotBlank(request.getParameter(BaseConstance.LOGIN_USER_ID))){
            return request.getParameter(BaseConstance.LOGIN_USER_ID);
        }
        // try fetch user id with cookies
        String cookieVal = getCookieVal(request.getCookies(), BaseConstance.LOGIN_USER_ID, null);
        if(StringUtils.isNotBlank(cookieVal)){
            return cookieVal;
        }
        return null;
    }
    
    /***
     * loop the cookies, match the cookies name.
     * if matched, return the cookie value,otherwise return defVal
     * @param cookies request.getCookies()
     * @param key use to match's cookie key
     * @param defVal is not any match,return this val
     * @return cookies value, if matched.
     */
    private String getCookieVal(Cookie[] cookies, String key, String defVal){
        if(cookies == null || cookies.length == 0){
            return defVal;
        }
        for (Cookie cookie : cookies) {
            if(cookie == null){
                continue;
            }
            if(key.equals(cookie.getName())){
                return cookie.getValue();
            }
        }
        return defVal;
    }
}
