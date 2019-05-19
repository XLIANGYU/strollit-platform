package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbPetDiary {
    private String id;

    private String petId;

    private String userId;

    private Integer isPrivate;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;

    private String contents;
    
}