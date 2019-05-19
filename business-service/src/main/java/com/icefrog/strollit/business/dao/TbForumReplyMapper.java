package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbForumReply;

public interface TbForumReplyMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbForumReply record);

    int insertSelective(TbForumReply record);

    TbForumReply selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbForumReply record);

    int updateByPrimaryKey(TbForumReply record);
}