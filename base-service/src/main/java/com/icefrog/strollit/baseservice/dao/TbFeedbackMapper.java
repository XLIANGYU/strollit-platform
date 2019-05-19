package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbFeedback;

public interface TbFeedbackMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbFeedback record);

    int insertSelective(TbFeedback record);

    TbFeedback selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbFeedback record);

    int updateByPrimaryKey(TbFeedback record);
}