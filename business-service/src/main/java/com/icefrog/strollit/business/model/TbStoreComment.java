package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbStoreComment {
    private String id;

    private String storeId;

    private String userId;

    private String comment;

    private Date createTime;

    private Integer isDel;

}