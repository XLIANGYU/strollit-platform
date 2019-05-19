package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStore;

public interface TbStoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStore record);

    int insertSelective(TbStore record);

    TbStore selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStore record);

    int updateByPrimaryKeyWithBLOBs(TbStore record);

    int updateByPrimaryKey(TbStore record);
}