package com.icefrog.strollit.baseservice.model;

import lombok.Data;

@Data
public class TbProductImg {
    private String id;

    private String productId;

    private String imgUrl;

    private String imgType;

    private Integer sortNum;

    private Integer isDel;
    
}