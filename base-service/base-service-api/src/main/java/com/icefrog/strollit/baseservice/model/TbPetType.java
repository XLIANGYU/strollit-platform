package com.icefrog.strollit.baseservice.model;

import lombok.Data;

@Data
public class TbPetType {
    private String id;

    private String typeName;

    private String logoUrl;

    private String descs;

    private Integer isDel;
    
}