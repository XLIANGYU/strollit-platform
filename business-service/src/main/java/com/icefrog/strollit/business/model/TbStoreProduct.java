package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbStoreProduct {
    private String id;

    private String baseProductId;

    private String storeId;

    private String createId;

    private Date createTime;

    private String updateId;

    private Date updateTime;

    private String productName;

    private Long originalPrice;

    private Long sellPrice;

    private String sellType;

    private String brandName;

    private String productSpec;

    private String venderName;

    private String productType;

    private Integer isDel;

    private String productDesc;
    
}