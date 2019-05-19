package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbPet;

public interface TbPetMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPet record);

    int insertSelective(TbPet record);

    TbPet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPet record);

    int updateByPrimaryKey(TbPet record);
}