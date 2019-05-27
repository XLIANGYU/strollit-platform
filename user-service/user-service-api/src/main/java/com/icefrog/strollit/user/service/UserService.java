/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.service;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.user.dto.UserDto;
import com.icefrog.strollit.user.model.TbRole;
import com.icefrog.strollit.user.model.TbUser;

import java.util.List;

public interface UserService {
    
    ApiResult<Integer> batchInsertUser(List<UserDto> users);
    
    TbUser selectByPrimaryKey(String id);
    
    ApiResult<UserDto> loginWithQueryUser(String account);
    
    ApiResult<List<TbUser>> pageQueryUserList(String userName, String nickName, String roleId, Integer pageIndex, Integer pageSize);
    
    ApiResult<UserDto> queryUserDetail(String userId);
    
    ApiResult updateUser(UserDto userDto);
    
    ApiResult batchRemoveUser(List<String> userIds);
    
    ApiResult saveUser(UserDto userDto);
    
}
