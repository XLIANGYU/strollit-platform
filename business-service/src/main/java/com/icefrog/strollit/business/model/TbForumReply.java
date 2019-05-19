package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbForumReply {
    private String id;

    private String forum;

    private String replyComment;

    private String replyImg;

    private Integer isRef;

    private String refReplyId;

    private Date createTime;

    private Long floorNum;

    private Integer isDel;
    
}