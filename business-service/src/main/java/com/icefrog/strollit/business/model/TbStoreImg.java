package com.icefrog.strollit.business.model;

import lombok.Data;

@Data
public class TbStoreImg {
    private String id;

    private String storeId;

    private String imgUrl;

    private String imgType;

    private Integer sortNum;

    private Integer isDel;

}