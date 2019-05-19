package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbPetMate;
import org.springframework.stereotype.Repository;

@Repository
public interface TbPetMateMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPetMate record);

    int insertSelective(TbPetMate record);

    TbPetMate selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPetMate record);

    int updateByPrimaryKey(TbPetMate record);
}