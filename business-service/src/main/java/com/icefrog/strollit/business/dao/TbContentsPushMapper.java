package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbContentsPush;
import org.springframework.stereotype.Repository;

@Repository
public interface TbContentsPushMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbContentsPush record);

    int insertSelective(TbContentsPush record);

    TbContentsPush selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbContentsPush record);

    int updateByPrimaryKeyWithBLOBs(TbContentsPush record);

    int updateByPrimaryKey(TbContentsPush record);
}