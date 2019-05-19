package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreSubscribe;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreSubscribeMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreSubscribe record);

    int insertSelective(TbStoreSubscribe record);

    TbStoreSubscribe selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreSubscribe record);

    int updateByPrimaryKey(TbStoreSubscribe record);
}