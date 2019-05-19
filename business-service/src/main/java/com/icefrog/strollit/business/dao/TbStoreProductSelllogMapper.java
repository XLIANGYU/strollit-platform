package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreProductSelllog;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreProductSelllogMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreProductSelllog record);

    int insertSelective(TbStoreProductSelllog record);

    TbStoreProductSelllog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreProductSelllog record);

    int updateByPrimaryKey(TbStoreProductSelllog record);
}