package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbSms;
import org.springframework.stereotype.Repository;

@Repository
public interface TbSmsMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbSms record);

    int insertSelective(TbSms record);

    TbSms selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbSms record);

    int updateByPrimaryKey(TbSms record);
}