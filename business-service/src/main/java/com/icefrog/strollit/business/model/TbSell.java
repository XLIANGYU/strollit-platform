package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbSell {
    private String id;

    private String userId;

    private String productName;

    private String originPrice;

    private String sellPrice;

    private String moneyType;

    private String buySrc;

    private Integer isInvoce;

    private Date createTime;

    private String status;

    private Integer isDel;

    private String comments;
    
}