package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbPetDiary;

public interface TbPetDiaryMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPetDiary record);

    int insertSelective(TbPetDiary record);

    TbPetDiary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPetDiary record);

    int updateByPrimaryKeyWithBLOBs(TbPetDiary record);

    int updateByPrimaryKey(TbPetDiary record);
}