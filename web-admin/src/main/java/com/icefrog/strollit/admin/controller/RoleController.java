/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.controller;

import com.icefrog.strollit.admin.service.RoleService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import com.icefrog.strollit.user.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/***
 * 角色管理控制器
 */
@Controller
@RequestMapping("/role")
public class RoleController extends ApiBaseController{
    
    @Autowired
    private RoleService roleService;
    
    @RequestMapping("/toAddRole")
    public String toAddRole(){
        return "/role/add_role";
    }
    
    @RequestMapping("/toEditRole")
    public String toEditRole(){
        return "";
    }
    
    @RequestMapping("/toRoleList")
    public String toRoleList(){
        return "";
    }
    
    @RequestMapping("/saveRole")
    @ResponseBody
    public ApiResult saveRole(@RequestParam(name = "roleName") String roleName,
                              @RequestParam(name = "roleComment") String roleComment){
    
        RoleDto role = new RoleDto();
        role.setRoleName(roleName);
        role.setRemark(roleComment);
        role.setCreateId("1");
        role.setUpdateId("1");
        
        return roleService.saveRole(role);
    }

}
