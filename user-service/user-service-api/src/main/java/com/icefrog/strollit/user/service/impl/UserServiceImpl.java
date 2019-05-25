/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.service.impl;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dao.TbUserMapper;
import com.icefrog.strollit.user.dto.UserDto;
import com.icefrog.strollit.user.mapstruct.UserMapStruct;
import com.icefrog.strollit.user.model.TbRole;
import com.icefrog.strollit.user.model.TbUser;
import com.icefrog.strollit.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl extends BaseServer implements UserService {
    
    @Autowired
    private TbUserMapper userMapper;
    
    @Override
    public ApiResult<Integer> batchInsertUser(List<UserDto> usersDtos) {
        if(CollectionUtils.isEmpty(usersDtos)){
            return new ApiResult<Integer>().success(0);
        }
    
        try {
            int count = 0;
            // 检查userDtos中是否存在已落库的数据, 有则排除
            for (int i = usersDtos.size() - 1; i >= 0; i--) {
                UserDto userDto = usersDtos.get(i);
                TbUser user = this.selectByPrimaryKey(userDto.getId());
                if (user != null && user.getIsDel() == 0) {
                    usersDtos.remove(i);
                    continue;
                }
                count++;
            }
    
            List<TbUser> users = UserMapStruct.INSTANCE.toUserModes(usersDtos);
            if(CollectionUtils.isEmpty(users)){
                return new ApiResult<Integer>().success(0);
            }
            userMapper.batchInsertUser(users);
            return new ApiResult<Integer>().success(count);
        } catch (Exception ex) {
            log.error("批量保存用户引发异常, 异常信息: " +ex.getMessage(), ex);
            return error("批量保存用户引发异常, 异常信息: "+ ex.getMessage());
        }
    }
    
    @Override
    public TbUser selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
