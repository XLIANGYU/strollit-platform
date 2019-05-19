package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreComment;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreComment record);

    int insertSelective(TbStoreComment record);

    TbStoreComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreComment record);

    int updateByPrimaryKey(TbStoreComment record);
}