package com.icefrog.strollit.baseservice.dao;

import com.icefrog.strollit.baseservice.model.TbRegion;
import org.springframework.stereotype.Repository;

@Repository
public interface TbRegionMapper {
    int deleteByPrimaryKey(String regionId);

    int insert(TbRegion record);

    int insertSelective(TbRegion record);

    TbRegion selectByPrimaryKey(String regionId);

    int updateByPrimaryKeySelective(TbRegion record);

    int updateByPrimaryKey(TbRegion record);
}