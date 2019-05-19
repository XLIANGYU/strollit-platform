package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbPartyUser;

public interface TbPartyUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPartyUser record);

    int insertSelective(TbPartyUser record);

    TbPartyUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPartyUser record);

    int updateByPrimaryKey(TbPartyUser record);
}