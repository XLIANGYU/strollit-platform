/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client.fallback;

import com.icefrog.strollit.admin.client.RoleFeignClient;
import com.icefrog.strollit.admin.dto.RoleDto;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.feign.BaseFallback;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RoleFeignClientFallback extends BaseFallback implements FallbackFactory<RoleFeignClient> {
    
    @Override
    public RoleFeignClient create(Throwable throwable) {
        return new RoleFeignClient() {
            @Override
            public ApiResult saveRole(RoleDto roleDto) {
                log.error("调用角色相关服务失败, 异常信息: ", throwable.getMessage(), throwable);
                return error("调用角色相关服务失败, " + throwable.getMessage());
            }
        };
    }
}
