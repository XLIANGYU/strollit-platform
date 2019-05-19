package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbPetKind;

public interface TbPetKindMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPetKind record);

    int insertSelective(TbPetKind record);

    TbPetKind selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPetKind record);

    int updateByPrimaryKey(TbPetKind record);
}