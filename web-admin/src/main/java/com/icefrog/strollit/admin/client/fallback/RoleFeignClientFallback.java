/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client.fallback;

import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.admin.client.RoleFeignClient;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.feign.BaseFallback;
import com.icefrog.strollit.user.dto.RoleDto;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleFeignClientFallback extends BaseFallback implements FallbackFactory<RoleFeignClient> {
    
    @Override
    public RoleFeignClient create(Throwable throwable) {
        return new RoleFeignClient() {
            
            @Override
            public ApiResult saveRole(RoleDto roleDto) {
                return errorHandler("调用角色相关服务失败", throwable);
            }
    
            @Override
            public ApiResult<Integer> batchInsertRole(List<RoleDto> roleDtos) {
                return errorHandler("调用角色相关服务失败", throwable);
            }
    
            @Override
            public ApiResult<PageInfo<RoleDto>>  pageQueryRoleList(Integer pageIndex, Integer pageSize, String name) {
                return errorHandler("调用角色相关服务失败", throwable);
            }
        };
    }
}
