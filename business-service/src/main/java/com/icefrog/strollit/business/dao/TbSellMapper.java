package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbSell;

public interface TbSellMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbSell record);

    int insertSelective(TbSell record);

    TbSell selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSell record);

    int updateByPrimaryKeyWithBLOBs(TbSell record);

    int updateByPrimaryKey(TbSell record);
}