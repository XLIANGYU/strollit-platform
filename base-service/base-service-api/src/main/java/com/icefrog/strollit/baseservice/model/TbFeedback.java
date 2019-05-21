package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbFeedback {
    private String id;

    private String userId;

    private Date createTime;

    private String contact;

    private String email;

    private String questionUrl;

    private String comment;

    private String src;

    private String status;

    private Integer isDel;
}