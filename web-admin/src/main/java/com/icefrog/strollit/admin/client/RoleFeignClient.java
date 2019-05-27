/*
 * Copyright 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.admin.client.fallback.RoleFeignClientFallback;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.microserver.ServiceId;
import com.icefrog.strollit.user.dto.RoleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value= ServiceId.USER_SERVICE, fallbackFactory = RoleFeignClientFallback.class)
public interface RoleFeignClient {

    @RequestMapping("/api/role/saveRole")
    ApiResult saveRole(@RequestBody RoleDto roleDto);
    
    @RequestMapping("/api/role/batchInsertRole")
    ApiResult<Integer> batchInsertRole(@RequestBody List<RoleDto> roleDtos);
    
    @RequestMapping("/api/role/pageQueryRoleList")
    ApiResult<PageInfo<RoleDto>>  pageQueryRoleList(@RequestParam(name = "pageIndex") Integer pageIndex,
                                                    @RequestParam(name = "pageSize") Integer pageSize,
                                                    @RequestParam(name = "name") String name);
    
    @RequestMapping("/api/role/batchRemove")
    ApiResult<Integer> batchRemove(@RequestBody List<String> roleIds);
    
    @RequestMapping("/api/role/updateRole")
    ApiResult updateRole(@RequestBody RoleDto roleDto);
    
    @RequestMapping("/api/role/selectRoleById")
    ApiResult<RoleDto> selectRoleById(@RequestParam(name = "roleId") String roleId);
}
