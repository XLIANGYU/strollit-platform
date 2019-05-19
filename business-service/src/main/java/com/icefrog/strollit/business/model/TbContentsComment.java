package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbContentsComment {
    private String id;

    private String userId;

    private String contentsPushId;

    private String comment;

    private Date createTime;

    private Integer isRef;

    private String refCommentId;

    private String res1;

    private String res2;

    private String res3;

    private Integer isDel;
    
}