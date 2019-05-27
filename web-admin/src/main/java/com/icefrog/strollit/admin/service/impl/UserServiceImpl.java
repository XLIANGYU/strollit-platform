/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.admin.service.impl;

import com.icefrog.strollit.admin.client.UserFeignClient;
import com.icefrog.strollit.admin.service.UserService;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.dto.UserDto;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServer implements UserService {
    
    @Autowired
    private UserFeignClient userFeignClient;
    
    @Override
    public ApiResult<Integer> batchInsertUser(List<UserDto> users) {
       return userFeignClient.batchInsertUser(users);
    }
    
    @Override
    public ApiResult<List<UserDto>> pageQueryUserList(String userName, String nickName, String roleId, Integer pageIndex, Integer pageSize) {
        return userFeignClient.pageQueryUserList(userName, nickName, roleId, pageIndex, pageSize);
    }
    
    @Override
    public ApiResult<UserDto> queryUserDetail(String userId) {
        return userFeignClient.queryUserDetailById(userId);
    }
    
    @Override
    public ApiResult updateUser(UserDto userDto) {
        return userFeignClient.updateUser(userDto);
    }
    
    @Override
    public ApiResult batchRemoveUser(List<String> userIds) {
        return userFeignClient.batchRemoveUser(userIds);
    }
    
    @Override
    public ApiResult saveUser(UserDto userDto) {
        return userFeignClient.saveUser(userDto);
    }
}
