/*
 * Copyright 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client;

import com.icefrog.strollit.admin.client.fallback.RoleFeignClientFallback;
import com.icefrog.strollit.admin.dto.RoleDto;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.microserver.ServiceId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value= ServiceId.USER_SERVICE, fallbackFactory = RoleFeignClientFallback.class)
public interface RoleFeignClient {

    @RequestMapping("/api/role/saveRole")
    ApiResult saveRole(@RequestBody RoleDto roleDto);

}
