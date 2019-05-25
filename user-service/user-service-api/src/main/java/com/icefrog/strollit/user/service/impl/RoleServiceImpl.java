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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Slf4j
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
    
        TbRole role = RoleMapStruct.INSTANCE.toRoleModel(roleDto);
        int insertSelective = roleMapper.insertSelective(role);
    
        return insertSelective > 0 ? success() : error();
    }
    
    @Override
    public ApiResult<Integer> batchSaveRole(List<RoleDto> roleDtos) {
        try {
            if (CollectionUtils.isEmpty(roleDtos)) {
                return new ApiResult<Integer>().success(0);
            }
    
            int count = 0;
            // 检查roleDtos中是否存在已落库的数据, 有则排除
            for (int i = roleDtos.size() - 1; i >= 0; i--) {
                RoleDto roleDto = roleDtos.get(i);
                TbRole role = this.selectByPrimaryKey(roleDto.getId());
                if (role != null && role.getIsDel() == 0) {
                    roleDtos.remove(i);
                    continue;
                }
                count++;
            }
            List<TbRole> roles = RoleMapStruct.INSTANCE.toRoleModes(roleDtos);
            if(CollectionUtils.isEmpty(roles)){
                return new ApiResult<Integer>().success(0);
            }
            roleMapper.batchInsertRole(roles);
            return new ApiResult<Integer>().success(count);
        } catch (Exception ex){
            log.error("批量保存角色引发异常, 异常信息: " +ex.getMessage(), ex);
            return error("批量保存角色引发异常, 异常信息: "+ ex.getMessage());
        }
    }
    
    @Override
    public TbRole selectByPrimaryKey(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
