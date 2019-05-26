

package com.icefrog.strollit.admin.filter;


import com.icefrog.strollit.admin.util.Constance;
import com.icefrog.strollit.admin.util.CookieUtils;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.constance.BaseConstance;
import com.icefrog.strollit.user.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 会话增强。在有别于JSESSIONID的前提下，新增uid(加密后)存储到cookie
 * 以实现不使用session记录当前登录用户信息
 *
 * @author icefrog.su@qq.com
 */
@Slf4j
@Order(value = 1024)
@WebFilter(filterName="uIDCookieFilter", urlPatterns="/*")
public class UIDCookieFilter implements Filter {
    
    public final List<String> excludeSuffixPools = new ArrayList<>();
    
    @Override
    public void init(FilterConfig filterConfig) {
        //初始化不需要过滤处理的静态资源
        excludeSuffixPools.add("js");
        excludeSuffixPools.add("css");
        excludeSuffixPools.add("jpg");
        excludeSuffixPools.add("jpeg");
        excludeSuffixPools.add("png");
        excludeSuffixPools.add("gif");
        excludeSuffixPools.add("ico");
        excludeSuffixPools.add("svg");
        
        // api uri
        excludeSuffixPools.add("login");
        excludeSuffixPools.add("doLogin");
        excludeSuffixPools.add("imagesCode");
    }
    
    /***
     * 过滤器逻辑实现
     * @param servletRequest ServletRequest object
     * @param servletResponse ServletResponse object
     * @param filterChain FilterChain object
     * @throws IOException maybe throw IOException
     * @throws ServletException maybe throw ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String requestURI = request.getRequestURI();
        if(requestURI != null && containExclude(requestURI)){
            //无须过滤的URI片段
            filterChain.doFilter(request, response);
        }else{
            //将请求头中cookies加密的uid进行解密并且存储到request中
            
            String userInfoBase64 = CookieUtils.getCookieValue(request, "userInfo");
            if(StringUtils.isBlank(userInfoBase64)){
                String loginPage =  "/system/login";
                String header = request.getHeader("X-Requested-With");
                if(header != null && header.equals("XMLHttpRequest")){
                    // ajax请求
                    ApiResult apiResult = new ApiResult();
                    Map<String,Object> data = new HashMap<>();
                    data.put("error_call_back", loginPage);
                    String unLoginJson = JSONObject.fromObject(apiResult.setCode(99).setMessage("当前未登录!").setData(data)).toString();
                    PrintWriter out = response.getWriter();
                    out.write(unLoginJson);
                    out.flush();
                    out.close();
                    return;
                }else {
                    // 普通请求直接跳转到bumng的登录页面
                    response.sendRedirect(loginPage);
                    return;
                }
            }else{
                //Base64.decode
                byte[] decode = java.util.Base64.getDecoder().decode(userInfoBase64);
                String userInfoJson = new String(decode);
                log.debug("从cookie中获取的userInfo为:{}", userInfoJson);
                //将userInfo放到请求头，便于后续使用(在cookies中操作不方便)
                UserDto userDto = (UserDto) JSONObject.toBean(JSONObject.fromObject(userInfoJson), UserDto.class);
                request.setAttribute(BaseConstance.UserInfoHeader,userDto);
            }
            filterChain.doFilter(request,response);
        }
    }
    
    @Override
    public void destroy() {
    }
    
    public boolean containExclude(String requestUri){
        for (String excludeSuffixPool : excludeSuffixPools) {
            if(requestUri.indexOf(excludeSuffixPool) >= 0){
                return true;
            }
        }
        return false;
    }
}
