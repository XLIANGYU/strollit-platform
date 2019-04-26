package com.icefrog.strollit.gateway.enums;

public enum FilterType {
    
    /** 请求被路由之前调用 */
    PRE("pre", "请求被路由之前调用"),
    
    /** 路由请求时候被调用 */
    ROUTING("routing", "路由请求时候被调用"),
    
    /** routing和error过滤器之后被调用 */
    POST("post", "routing和error过滤器之后被调用"),
    
    /** 处理请求时发生错误时被调用 */
    ERROR("error", "处理请求时发生错误时被调用");
    
    /** 路由(过滤)类型 */
    private String filterType;
    
    /** 路由(过滤)描述 */
    private String filterDescribe;
    
    FilterType(final String filterType, final String filterDescribe){
        this.filterType = filterType;
        this.filterDescribe = filterDescribe;
    }
    
    public String getFilterType(){
        return this.filterType;
    }
    
    public String getFilterDescribe(){
        return this.filterDescribe;
    }
    
}