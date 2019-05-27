/*
 * Copyright 2019 zoohub.cn All rights reserved.
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
            
            @Override
            public ApiResult<UserDto> loginWithQueryUser(String account) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            @Override
            public ApiResult<List<UserDto>> pageQueryUserList(String account, String nickName, String roleId, Integer pageIndex, Integer pageSize) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            @Override
            public ApiResult<UserDto> queryUserDetailById(String userId) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            @Override
            public ApiResult updateUser(UserDto userDto) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            @Override
            public ApiResult batchRemoveUser(List<String> userIds) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
    
            @Override
            public ApiResult saveUser(UserDto userDto) {
                return errorHandler("调用用户相关服务失败", throwable);
            }
        };
    }
}
