/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.service;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.model.TbRole;

import java.util.List;

public interface RoleService {
    
    ApiResult saveRole(RoleDto roleDto);
    
    ApiResult<Integer> batchSaveRole(List<RoleDto> roleDtos);
    
    TbRole selectByPrimaryKey(String id);
    
    ApiResult<PageInfo<TbRole>> pageQueryRoleList(Integer pageIndex, Integer pageSize, String name);

    ApiResult<Integer> batchRemove(List<String> roleIds);
    
    ApiResult updateRole(RoleDto roleDto);
    
    ApiResult<RoleDto> selectRoleById(String roleId);
    
}
