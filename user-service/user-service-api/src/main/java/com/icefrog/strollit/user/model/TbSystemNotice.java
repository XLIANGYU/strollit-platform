package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbSystemNotice {
    private String id;

    private String createSrc;

    private String createId;

    private String title;

    private String contents;

    private Date createTime;

    private String recUserId;

    private Integer isRead;

    private Integer isDel;
    
}