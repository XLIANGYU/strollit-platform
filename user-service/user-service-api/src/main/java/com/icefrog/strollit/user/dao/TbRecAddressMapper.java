package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbRecAddress;
import org.springframework.stereotype.Repository;

@Repository
public interface TbRecAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbRecAddress record);

    int insertSelective(TbRecAddress record);

    TbRecAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbRecAddress record);

    int updateByPrimaryKey(TbRecAddress record);
}