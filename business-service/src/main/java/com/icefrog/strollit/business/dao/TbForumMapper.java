package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbForum;
import org.springframework.stereotype.Repository;

@Repository
public interface TbForumMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbForum record);

    int insertSelective(TbForum record);

    TbForum selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbForum record);

    int updateByPrimaryKeyWithBLOBs(TbForum record);

    int updateByPrimaryKey(TbForum record);
}