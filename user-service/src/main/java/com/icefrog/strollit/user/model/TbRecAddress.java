package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbRecAddress {
    private String id;

    private String userId;

    private Date createTime;

    private Date updateTime;

    private String belong;

    private String consignee;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String cityName;

    private String countyId;

    private String countyName;

    private String townId;

    private String townName;

    private String address;

    private String email;

    private String mobile;

    private String tel;

    private Integer isDefault;

    private Integer isDel;
    
}