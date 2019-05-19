package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreImg;

public interface TbStoreImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreImg record);

    int insertSelective(TbStoreImg record);

    TbStoreImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreImg record);

    int updateByPrimaryKey(TbStoreImg record);
}