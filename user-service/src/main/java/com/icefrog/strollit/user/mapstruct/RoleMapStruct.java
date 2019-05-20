/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.mapstruct;

import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.model.TbRole;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapStruct {
    
    RoleMapStruct MAPPER = Mappers.getMapper(RoleMapStruct.class);
    
    RoleDto toRoleDto(TbRole role);
    
    List<RoleDto> toRoleDtos(List<TbRole> roles);
    
    TbRole toRoleModel(RoleDto roleDto);

}
