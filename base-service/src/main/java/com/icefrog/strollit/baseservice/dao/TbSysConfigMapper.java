package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbSysConfig;

public interface TbSysConfigMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbSysConfig record);

    int insertSelective(TbSysConfig record);

    TbSysConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSysConfig record);

    int updateByPrimaryKey(TbSysConfig record);
}