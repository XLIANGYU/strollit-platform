package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbProductImg;

public interface TbProductImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbProductImg record);

    int insertSelective(TbProductImg record);

    TbProductImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbProductImg record);

    int updateByPrimaryKey(TbProductImg record);
}