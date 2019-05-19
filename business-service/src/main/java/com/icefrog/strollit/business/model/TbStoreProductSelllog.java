package com.icefrog.strollit.business.model;

import lombok.Data;

@Data
public class TbStoreProductSelllog {
    private String id;

    private String storeProductId;

    private String orderId;

    private String orderNum;

    private Integer isDel;
    
}