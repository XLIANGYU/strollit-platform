/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.web;

import com.icefrog.strollit.baseframework.domain.UserDto;

import javax.servlet.http.HttpServletRequest;

/***
 * BaseController
 *
 * @since 1.0
 * @author icefrog.su@qq.com
 */
public abstract class BaseController extends BaseServer implements IController {
    
    /***
     * 获取当前登录的用户基础信息。 当前request 中若不包含登录用户信息则返回null
     * @param request HttpServletRequest request
     * @return UserDto
     */
    @Override
    public UserDto getUser(HttpServletRequest request) {
        // TODO 解析 http request header 获取用户信息
        return null;
    }
}
