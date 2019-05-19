package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbSysConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface TbSysConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbSysConfig record);

    int insertSelective(TbSysConfig record);

    TbSysConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSysConfig record);

    int updateByPrimaryKey(TbSysConfig record);
}