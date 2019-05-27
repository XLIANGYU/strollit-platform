/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.controller;

import com.icefrog.strollit.admin.service.UserService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.constance.PermissionConstance;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import com.icefrog.strollit.user.dto.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/user-api")
@RestController
public class WebApiUserController extends ApiBaseController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/initUserList")
    public ApiResult<List<UserDto>> initUserList(@RequestParam(name = "account", required = false) String account,
                                                 @RequestParam(name = "nickName", required = false) String nickName,
                                                 @RequestParam(name = "roleId", required = false) String roleId,
                                                 @RequestParam(name = "pageIndex") Integer pageIndex,
                                                 @RequestParam(name = "pageSize") Integer pageSize) {
        return userService.pageQueryUserList(account, nickName, roleId, pageIndex, pageSize);
    }
    
    @RequestMapping("/saveUser")
    public ApiResult saveUser(UserDto userDto) {
        return userService.saveUser(userDto);
    }
    
    @RequestMapping("/editUser")
    public ApiResult editUser(UserDto userDto) {
        return userService.updateUser(userDto);
    }
    
    @RequestMapping("/batchRemoveUser")
    public ApiResult batchRemoveUser(String idsStr) {
        if(StringUtils.isEmpty(idsStr)){
            return error("请选择需要删除的数据项!");
        }
        String[] idArray = idsStr.split(",");
        List<String> ids = new ArrayList<>(idArray.length);
        for (String s : idArray) {
            if(StringUtils.isEmpty(s)){
                continue;
            }
            if(s.equals(PermissionConstance.INTERNALLY_USER_ID)){
                continue;
            }
            ids.add(s);
        }
        return userService.batchRemoveUser(ids);
    }
    
    @RequestMapping("/initUserDetail")
    public ApiResult initUserDetail(String userId) {
        return userService.queryUserDetail(userId);
    }
}
