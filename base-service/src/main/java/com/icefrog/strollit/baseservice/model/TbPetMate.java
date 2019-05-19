package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbPetMate {
    private String id;

    private String petId;

    private String metePetId;

    private Date startTime;

    private Date endTime;

    private String status;

    private String res1;

    private String res2;

    private String res3;

    private Integer isDel;
    
}