/*
 * Copyright 2019 版权所有
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
    
}
