/*
 * Copyright 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client;

import com.icefrog.strollit.admin.client.fallback.UserFeignClientFallback;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.microserver.ServiceId;
import com.icefrog.strollit.user.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value= ServiceId.USER_SERVICE, fallbackFactory = UserFeignClientFallback.class)
public interface UserFeignClient {
    
    @RequestMapping("/api/user/batchInsertUser")
    ApiResult<Integer> batchInsertUser(@RequestBody List<UserDto> userDtos);

}
