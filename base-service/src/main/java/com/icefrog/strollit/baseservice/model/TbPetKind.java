package com.icefrog.strollit.baseservice.model;

import lombok.Data;

@Data
public class TbPetKind {
    private String id;

    private String petTypeId;

    private String kindName;

    private String kindUrl;

    private String descs;

    private Integer isDel;
    
}