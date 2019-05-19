package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbStore {
    private String id;

    private String adminId;

    private String provinceId;

    private String cityId;

    private String countyId;

    private String townId;

    private String storeName;

    private Date createTime;

    private String createId;

    private Date updateTime;

    private String updateId;

    private String mapX;

    private String mapY;

    private String logUrl;

    private String onlineTime;

    private String storeMobile;

    private String storeTelphone;

    private String storeWx;

    private String storeQq;

    private Long storeRank;

    private Integer isDisable;

    private Integer isDestory;

    private Integer isDel;

    private String storeDesc;
    
}