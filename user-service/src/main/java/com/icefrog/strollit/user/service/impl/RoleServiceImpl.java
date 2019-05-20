/*
 * Copyright icefrog software 2019 版权所有
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.user.service.impl;

import com.icefrog.strollit.baseframework.api.ApiResult;
import com.icefrog.strollit.baseframework.util.IDGenerate;
import com.icefrog.strollit.baseframework.web.BaseServer;
import com.icefrog.strollit.user.dao.TbRoleMapper;
import com.icefrog.strollit.user.dto.RoleDto;
import com.icefrog.strollit.user.mapstruct.RoleMapStruct;
import com.icefrog.strollit.user.model.TbRole;
import com.icefrog.strollit.user.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
public class RoleServiceImpl extends BaseServer implements RoleService {
    
    @Autowired
    private TbRoleMapper roleMapper;
    
    @Override
    public ApiResult saveRole(RoleDto roleDto) {
    
        Assert.notNull(roleDto, "RoleDto is null!");
        Assert.notNull(roleDto.getRoleName(), "Role's RoleName is null!");
        Assert.notNull(roleDto.getCreateId(), "Role's CreateId is null!");
        Assert.notNull(roleDto.getUpdateId(), "Role's UpdateId is null!");
        
        if(StringUtils.isBlank(roleDto.getId())){
            roleDto.setId(IDGenerate.buildID());
        }
        roleDto.setIsDel(0);
        roleDto.setCreateTime(new Date());
        roleDto.setUpdateTime(new Date());
    
        TbRole role = RoleMapStruct.MAPPER.toRoleModel(roleDto);
        int insertSelective = roleMapper.insertSelective(role);
    
        return insertSelective > 0 ? success() : error();
    }
}
