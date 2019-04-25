/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.eureka.plugin;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 禁用SpringCloud2.0新增的csrf校验。默认此校验会导致其他服务连接到此注册中心失败
 * 或者无法进入管理页面
 * 这是使用security进行连接鉴权导致的后果
 * @author icefrog.su@qq.com
 */
@EnableWebSecurity
public class WebSecurityConfigurerAdapterImpl extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //SpringCloud 2.0 默认启用csrf校验。此处关闭此校验
        http.csrf().disable();
        // 关闭iframe跨域,否则注册中心页面无法在iframe框架集中展示
        http.headers().frameOptions().disable();
        super.configure(http);
    }
    
}
