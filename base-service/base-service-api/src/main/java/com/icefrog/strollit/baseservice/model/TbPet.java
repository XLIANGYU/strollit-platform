package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbPet {
    private String id;

    private String userId;

    private String petTypeId;

    private String petKindId;

    private String petName;

    private Date birthday;

    private String petFaceUrl;

    private String sex;

    private String petColor;

    private String weight;

    private String skill;

    private String remark;

    private Integer isDel;
    
}