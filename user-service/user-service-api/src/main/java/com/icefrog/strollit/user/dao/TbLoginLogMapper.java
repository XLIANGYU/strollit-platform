package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbLoginLog;
import org.springframework.stereotype.Repository;

@Repository
public interface TbLoginLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbLoginLog record);

    int insertSelective(TbLoginLog record);

    TbLoginLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbLoginLog record);

    int updateByPrimaryKey(TbLoginLog record);
}