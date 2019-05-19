package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbOpLog;

public interface TbOpLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbOpLog record);

    int insertSelective(TbOpLog record);

    TbOpLog selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbOpLog record);

    int updateByPrimaryKey(TbOpLog record);
}