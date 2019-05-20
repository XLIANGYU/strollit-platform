/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.api;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/***
 * 角色相关接口
 */
@RestController
@RequestMapping("/api/role")
public class ApiRoleController extends ApiBaseController {

    @Autowired
    private RoleService roleService;
    
    /***
     * 新增一个角色信息, createId, updateId, roleName不允许为空
     * @param roleDto RoleDto
     * @return ApiResult
     */
    @RequestMapping("/saveRole")
    public ApiResult saveRole(@RequestBody RoleDto roleDto){
        return roleService.saveRole(roleDto);
    }

}
