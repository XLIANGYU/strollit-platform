/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.mapstruct;

import com.icefrog.strollit.user.dto.UserDto;
import com.icefrog.strollit.user.model.TbUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapStruct {
    
    UserMapStruct INSTANCE = Mappers.getMapper(UserMapStruct.class);
    
    List<TbUser> toUserModes(List<UserDto> userDtos);
    
    List<UserDto> toUserDtos(List<TbUser> users);
    
    TbUser toUserModel(UserDto userDto);
    
    UserDto toUserDto(TbUser user);
    
}
