package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbProduct;

public interface TbProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbProduct record);

    int insertSelective(TbProduct record);

    TbProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbProduct record);

    int updateByPrimaryKeyWithBLOBs(TbProduct record);

    int updateByPrimaryKey(TbProduct record);
}