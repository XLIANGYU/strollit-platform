package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbPetType;
import org.springframework.stereotype.Repository;

@Repository
public interface TbPetTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbPetType record);

    int insertSelective(TbPetType record);

    TbPetType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbPetType record);

    int updateByPrimaryKey(TbPetType record);
}