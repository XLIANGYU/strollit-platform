package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbStoreVipUser {
    private String id;

    private String storeId;

    private String userId;

    private String vipType;

    private Date createTime;

    private String createId;

    private Date updateTime;

    private String updateId;

    private String remark;

    private Integer isDel;
    
}