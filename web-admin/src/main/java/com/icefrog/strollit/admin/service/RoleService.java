/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.RoleDto;

import java.util.List;

public interface RoleService {
    
    ApiResult saveRole(RoleDto roleDto);
    
    ApiResult<Integer> batchInsertRole(List<RoleDto> roleDtos);

}
