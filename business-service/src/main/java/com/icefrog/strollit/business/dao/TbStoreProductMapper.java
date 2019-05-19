package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreProduct;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreProductMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreProduct record);

    int insertSelective(TbStoreProduct record);

    TbStoreProduct selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreProduct record);

    int updateByPrimaryKeyWithBLOBs(TbStoreProduct record);

    int updateByPrimaryKey(TbStoreProduct record);
}