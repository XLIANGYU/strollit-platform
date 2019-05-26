/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service.impl;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.admin.client.RoleFeignClient;
import com.icefrog.strollit.admin.service.RoleService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServer implements RoleService {
    
    @Autowired
    private RoleFeignClient feignClient;
    
    @Override
    public ApiResult saveRole(RoleDto roleDto) {
        return feignClient.saveRole(roleDto);
    }
    
    @Override
    public ApiResult<Integer> batchInsertRole(List<RoleDto> roleDtos) {
        return feignClient.batchInsertRole(roleDtos);
    }
    
    @Override
    public ApiResult<PageInfo<RoleDto>>  pageQueryRoleList(Integer pageIndex, Integer pageSize, String name) {
        return feignClient.pageQueryRoleList(pageIndex, pageSize, name);
    }
}
