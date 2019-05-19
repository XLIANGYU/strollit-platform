package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreManageType;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreManageTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreManageType record);

    int insertSelective(TbStoreManageType record);

    TbStoreManageType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreManageType record);

    int updateByPrimaryKey(TbStoreManageType record);
}