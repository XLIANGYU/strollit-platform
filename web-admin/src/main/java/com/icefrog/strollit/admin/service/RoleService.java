/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.RoleDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.IntegerSyntax;
import java.util.List;

public interface RoleService {
    
    ApiResult saveRole(RoleDto roleDto);
    
    ApiResult<Integer> batchInsertRole(List<RoleDto> roleDtos);
    
    ApiResult<PageInfo<RoleDto>> pageQueryRoleList(Integer pageIndex, Integer pageSize, String name);
    
    ApiResult<Integer> batchRemove(List<String> roleIds);
    
    ApiResult updateRole(RoleDto roleDto);
    
    ApiResult<RoleDto> selectRoleDtoById(String roleId);
    
}
