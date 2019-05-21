package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);
    
    int batchInsertRole(@Param("list")List<TbRole> roles);
}