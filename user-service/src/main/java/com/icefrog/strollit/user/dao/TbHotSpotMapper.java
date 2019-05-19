package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbHotSpot;

public interface TbHotSpotMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHotSpot record);

    int insertSelective(TbHotSpot record);

    TbHotSpot selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHotSpot record);

    int updateByPrimaryKey(TbHotSpot record);
}