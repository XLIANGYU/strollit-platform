package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbRegion {
    private String regionId;

    private String regionParentId;

    private String regionName;

    private Integer regionType;

    private String createId;

    private Date createTime;

    private String updateId;

    private Date updateTime;

    private Integer isDel;
    
}