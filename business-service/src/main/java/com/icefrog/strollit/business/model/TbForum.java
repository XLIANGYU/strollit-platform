package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbForum {
    private String id;

    private String createId;

    private Date createTime;

    private String title;

    private String imgUrl;

    private String forumType;

    private Integer isDel;

    private String contents;
    
}