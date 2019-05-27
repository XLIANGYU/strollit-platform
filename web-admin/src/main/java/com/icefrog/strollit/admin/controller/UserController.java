/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.controller;

import com.icefrog.strollit.baseframework.web.WebBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * user相关控制器
 * @see: ${WebApiUserController}
 *
 * @author icefrog.su@qq.com
 */
@RequestMapping("/user")
@Controller
public class UserController extends WebBaseController {

    @RequestMapping("/toUserList")
    public String toUserList(){
        return "/user/list_user";
    }
    
    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "/user/add_user";
    }
    
    @RequestMapping("/toEditUser")
    public String toEditUser(@RequestParam(name = "userId") String userId) {
        getRequest().setAttribute("userId", userId);
        return "/user/edit_user";
    }

}
