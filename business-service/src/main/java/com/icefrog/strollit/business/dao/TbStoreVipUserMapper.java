package com.icefrog.strollit.business.dao;

import com.icefrog.strollit.business.model.TbStoreVipUser;
import org.springframework.stereotype.Repository;

@Repository
public interface TbStoreVipUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbStoreVipUser record);

    int insertSelective(TbStoreVipUser record);

    TbStoreVipUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbStoreVipUser record);

    int updateByPrimaryKey(TbStoreVipUser record);
}