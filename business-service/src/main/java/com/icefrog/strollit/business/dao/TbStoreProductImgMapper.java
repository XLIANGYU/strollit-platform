package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreProductImg;

public interface TbStoreProductImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreProductImg record);

    int insertSelective(TbStoreProductImg record);

    TbStoreProductImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreProductImg record);

    int updateByPrimaryKey(TbStoreProductImg record);
}