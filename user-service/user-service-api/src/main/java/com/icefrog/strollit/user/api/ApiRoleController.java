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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

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
    
    /***
     * 批量保存角色信息, 当角色存在（ID）且未逻辑删除则忽略保存该数据. 具体保存成功的数量
     * 取决于ApiResult<Integer>指定内容
     * @param roleDtos role dto list
     * @return ApiResult<Integer>
     */
    @RequestMapping("/batchInsertRole")
    public ApiResult<Integer> batchInsertRole(@RequestBody List<RoleDto> roleDtos){
        return roleService.batchSaveRole(roleDtos);
    }
    
    @RequestMapping("/pageQueryRoleList")
    public ApiResult pageQueryRoleList(@RequestParam(name = "pageIndex") Integer pageIndex,
                                       @RequestParam(name = "pageSize") Integer pageSize,
                                       @RequestParam(name = "name") String name) {
        return roleService.pageQueryRoleList(pageIndex, pageSize, name);
    }
    
}
