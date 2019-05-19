package com.icefrog.strollit.business.model;

import lombok.Data;

@Data
public class TbStoreProductImg {
    private String id;

    private String productId;

    private String imgUrl;

    private String imgType;

    private Integer sortNum;

    private Integer isDel;

}