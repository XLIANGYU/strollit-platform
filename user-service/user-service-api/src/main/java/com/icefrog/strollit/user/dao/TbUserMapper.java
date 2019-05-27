package com.icefrog.strollit.user.dao;

import com.icefrog.strollit.user.model.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);
    
    int batchInsertUser(@Param("list")List<TbUser> users);
    
    TbUser queryUserWithLogin(@Param("account") String account);
    
    int logicRemove(@Param("id") String id);
    
    List<TbUser> pageQueryUser(@Param("account") String account, @Param("nickName") String nickName, @Param("roleId") String roleId);
    
}