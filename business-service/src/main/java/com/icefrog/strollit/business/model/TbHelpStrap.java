package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbHelpStrap {
    private String id;

    private String userId;

    private String petId;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    private Integer isUrgent;

    private Integer isUsePetInfo;

    private String petImgList;

    private Integer isDel;

    private String comments;

}