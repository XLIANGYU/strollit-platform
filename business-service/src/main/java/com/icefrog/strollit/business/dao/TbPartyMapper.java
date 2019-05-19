package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbParty;

public interface TbPartyMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbParty record);

    int insertSelective(TbParty record);

    TbParty selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbParty record);

    int updateByPrimaryKey(TbParty record);
}