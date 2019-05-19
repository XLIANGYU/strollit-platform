package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbContentsComment;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentsCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbContentsComment record);

    int insertSelective(TbContentsComment record);

    TbContentsComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbContentsComment record);

    int updateByPrimaryKey(TbContentsComment record);
}