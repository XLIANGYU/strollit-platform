package com.icefrog.strollit.order.dao;

import com.icefrog.strollit.order.model.TbOrder;

public interface TbOrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}