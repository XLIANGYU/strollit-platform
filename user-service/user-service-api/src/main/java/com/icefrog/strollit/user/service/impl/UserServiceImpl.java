/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.util.IDGenerate;
import com.icefrog.strollit.baseframework.util.PasswdUtils;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dao.TbUserMapper;
import com.icefrog.strollit.user.dto.UserDto;
import com.icefrog.strollit.user.mapstruct.UserMapStruct;
import com.icefrog.strollit.user.model.TbRole;
import com.icefrog.strollit.user.model.TbUser;
import com.icefrog.strollit.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    
    @Override
    public ApiResult<UserDto> loginWithQueryUser(String account) {
        try {
    
            TbUser user = userMapper.queryUserWithLogin(account);
    
            UserDto userDto = UserMapStruct.INSTANCE.toUserDto(user);
    
            return new ApiResult<UserDto>().success(userDto);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ApiResult<UserDto>().error();
        }
    }
    
    @Override
    public ApiResult<List<TbUser>> pageQueryUserList(String userName, String nickName, String roleId, Integer pageIndex, Integer pageSize) {
        
        if(StringUtils.isNotBlank(userName)){
            userName = "%" + userName + "%";
        }else{
            userName = null;
        }
        if(StringUtils.isEmpty(roleId)){
            roleId = null;
        }
    
        PageHelper.startPage(pageIndex, pageSize);
        List<TbUser> users = userMapper.pageQueryUser(userName, nickName, roleId);
        PageInfo<TbUser> info = new PageInfo<>(users);
    
        return null;
    }
    
    @Override
    public ApiResult<UserDto> queryUserDetail(String userId) {
    
        TbUser user = this.selectByPrimaryKey(userId);
        UserDto userDto = UserMapStruct.INSTANCE.toUserDto(user);
    
        return new ApiResult<UserDto>().success(userDto);
    }
    
    @Override
    public ApiResult updateUser(UserDto userDto) {
        
        if(userDto == null){
            return error("需要修改的用户信息不允许为空!");
        }
    
        TbUser user = UserMapStruct.INSTANCE.toUserModel(userDto);
        int result = userMapper.updateByPrimaryKeySelective(user);
    
        return result > 0 ? success() : error();
    }
    
    @Override
    public ApiResult batchRemoveUser(List<String> userIds) {
        for (String userId : userIds) {
            userMapper.logicRemove(userId);
        }
        return success(String.format("删除成功, 共删除%d条数据!", userIds.size()));
    }
    
    @Override
    public ApiResult saveUser(UserDto userDto) {
        
        if(userDto == null){
            return error("待保存的用户信息不允许为空!");
        }
    
        TbUser user = UserMapStruct.INSTANCE.toUserModel(userDto);
        user.setId(IDGenerate.buildID());
        String salt = String.valueOf(System.currentTimeMillis());
        user.setPasswd(PasswdUtils.buildPasswd(user.getPasswd(), salt));
        user.setSalt(salt);
        user.setIsDestory(0);
        user.setIsDisable(0);
        user.setIsDel(0);
    
        int result = userMapper.insertSelective(user);
        return result > 0 ? success() : error();
    }
}
