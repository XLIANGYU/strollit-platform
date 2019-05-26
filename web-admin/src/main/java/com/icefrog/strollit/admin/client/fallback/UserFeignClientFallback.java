/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.client.fallback;

import com.icefrog.strollit.admin.client.UserFeignClient;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.feign.BaseFallback;
import com.icefrog.strollit.user.dto.UserDto;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignClientFallback extends BaseFallback implements FallbackFactory<UserFeignClient> {
    
    
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient(){
    
            @Override
            public ApiResult<Integer> batchInsertUser(List<UserDto> userDtos) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            /***
             * 使用account账户信息检索一个用户(仅排除逻辑删除)
             * @param account 登录账户
             * @return ApiResult<UserDto>
             */
            @Override
            public ApiResult<UserDto> loginWithQueryUser(String account) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
        };
    }
}
