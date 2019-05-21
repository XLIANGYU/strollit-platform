/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service.impl;

import com.icefrog.strollit.admin.client.RoleFeignClient;
import com.icefrog.strollit.admin.service.RoleService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServer implements RoleService {
    
    @Autowired
    private RoleFeignClient feignClient;
    
    @Override
    public ApiResult saveRole(RoleDto roleDto) {
        return feignClient.saveRole(roleDto);
    }
}
