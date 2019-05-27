/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.controller;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.admin.service.RoleService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.constance.PermissionConstance;
import com.icefrog.strollit.baseframework.web.ApiBaseController;
import com.icefrog.strollit.user.dto.RoleDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public String toEditRole(@RequestParam(name = "roleId") String roleId){
        getRequest().setAttribute("roleId", roleId);
        return "/role/edit_role";
    }
    
    @RequestMapping("/toRoleList")
    public String toRoleList(){
        return "/role/list_role";
    }
    
    @RequestMapping("/saveRole")
    @ResponseBody
    public ApiResult saveRole(@RequestParam(name = "roleName") String roleName,
                              @RequestParam(name = "roleComment") String roleComment){
    
        RoleDto role = new RoleDto();
        role.setRoleName(roleName);
        role.setRemark(roleComment);
        role.setCreateId(getUserId());
        role.setUpdateId(getUserId());
        return roleService.saveRole(role);
    }
    
    @RequestMapping("initRoles")
    @ResponseBody
    public ApiResult initRoles(@RequestParam(name = "pageIndex") Integer pageIndex,
                                                  @RequestParam(name = "pageSize") Integer pageSize,
                                                  @RequestParam(name = "name") String name){
        ApiResult<PageInfo<RoleDto>> pageInfoApiResult = roleService.pageQueryRoleList(pageIndex, pageSize, name);
        return success("roles", pageInfoApiResult.getData());
    }
    
    @RequestMapping("/batchRemove")
    @ResponseBody
    public ApiResult batchRemove(@RequestParam(name = "ids") String idsStr){
        if(StringUtils.isEmpty(idsStr)){
            return success("请选择需要删除的数据项!");
        }
    
        String[] idArray = idsStr.split(",");
        List<String> ids = new ArrayList<>(idArray.length);
        for (String s : idArray) {
            if(StringUtils.isEmpty(s)){
                continue;
            }
            if(s.equals(PermissionConstance.INTERNALLY_ADMIN_ROLE_ID)
                || s.equals(PermissionConstance.INTERNALLY_STORE_ROLE_ID)
                || s.equals(PermissionConstance.INTERNALLY_USER_ROLE_ID)){
                // 避免删除内置角色
                continue;
            }
            ids.add(s);
        }
        ApiResult<Integer> removeApiResult = roleService.batchRemove(ids);
        return success(String.format("删除成功, 本次共删除%d条数据!",removeApiResult.getData()));
    }
    
    @RequestMapping("/initRoleDetail")
    @ResponseBody
    public ApiResult<RoleDto> initRoleDetail(@RequestParam(name = "roleId") String roleId) {
        ApiResult<RoleDto> roleDtoApiResult = roleService.selectRoleDtoById(roleId);
        if(roleDtoApiResult == null || roleDtoApiResult.getData() == null || roleDtoApiResult.isError()) {
            return error("初始化角色信息失败!");
        }
        return roleDtoApiResult;
    }
    
    @RequestMapping("/updateRole")
    @ResponseBody
    public ApiResult updateRole(@RequestParam(name = "id") String id,
                                @RequestParam(name = "roleName") String roleName,
                                @RequestParam(name = "roleRemark") String roleRemark) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(id);
        roleDto.setRoleName(roleName);
        roleDto.setRemark(roleRemark);
        roleDto.setUpdateId(getUserId());
        roleDto.setUpdateTime(new Date());
        return roleService.updateRole(roleDto);
    }

}
