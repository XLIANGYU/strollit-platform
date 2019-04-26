package com.icefrog.strollit.gateway.filter.pre;

import com.icefrog.strollit.gateway.enums.FilterType;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/***
 * 基础Zuul过滤器
 *
 * @author icefrog.su@qq.com
 */
@Slf4j
public class BaseFilter extends ZuulFilter {
    
    /** 默认排序值, 数值越小优先级越高 */
    public static final int DEFAULT_ORDER = 0;
    
    /** 默认运行开关 */
    public static final boolean RUN_SWITCH = true;
    
    @Override
    public String filterType() {
        return FilterType.PRE.getFilterType();
    }
    
    @Override
    public int filterOrder() {
        return DEFAULT_ORDER;
    }
    
    @Override
    public boolean shouldFilter() {
        return RUN_SWITCH;
    }
    
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
    
        log.info("Routing.. Request method:[{}], Request Url:[{}]", request.getMethod(), request.getRequestURI());
        
        return null;
    }
}