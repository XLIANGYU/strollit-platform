package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbStoreSubscribe {
    private String id;

    private String storeId;

    private String userId;

    private String storeProductId;

    private String mobile;

    private Date startTime;

    private Date endTime;

    private String comment;

    private Integer isDel;

}