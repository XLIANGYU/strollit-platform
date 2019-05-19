package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbHelpStrap;
import org.springframework.stereotype.Repository;

@Repository
public interface TbHelpStrapMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbHelpStrap record);

    int insertSelective(TbHelpStrap record);

    TbHelpStrap selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbHelpStrap record);

    int updateByPrimaryKeyWithBLOBs(TbHelpStrap record);

    int updateByPrimaryKey(TbHelpStrap record);
}