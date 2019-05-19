package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
}