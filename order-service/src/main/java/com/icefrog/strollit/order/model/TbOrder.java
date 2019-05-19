package com.icefrog.strollit.order.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbOrder {
    private String id;

    private String userId;

    private String storeId;

    private String orderNum;

    private Date createTime;

    private String orderStatus;
    
}