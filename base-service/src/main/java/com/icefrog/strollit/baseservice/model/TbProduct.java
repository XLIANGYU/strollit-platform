package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbProduct {
    private String id;

    private String createId;

    private Date createTime;

    private String updateId;

    private Date updateTime;

    private String productName;

    private Long originalPrice;

    private Long sellPrice;

    private String brandName;

    private String productSpec;

    private String venderName;

    private String productType;

    private Integer isDel;

    private String productDesc;
    
}