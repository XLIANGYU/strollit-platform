/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service;

import com.icefrog.strollit.admin.dto.RoleDto;
import com.icefrog.strollit.baseframework.api.ApiResult;

public interface RoleService {
    
    ApiResult saveRole(RoleDto roleDto);

}
