package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbContentsPush {
    private String id;

    private String userId;

    private String userType;

    private Long sortNum;

    private String title;

    private String subtitle;

    private String headerImageUrl;

    private Date createTime;

    private Long likeCount;

    private Integer isOriginal;

    private String refUrl;

    private Integer isDel;

    private String contents;

}