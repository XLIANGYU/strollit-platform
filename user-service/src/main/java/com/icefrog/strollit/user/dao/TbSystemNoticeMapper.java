package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbSystemNotice;

public interface TbSystemNoticeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbSystemNotice record);

    int insertSelective(TbSystemNotice record);

    TbSystemNotice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSystemNotice record);

    int updateByPrimaryKey(TbSystemNotice record);
}