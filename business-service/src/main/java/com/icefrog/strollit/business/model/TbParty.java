package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbParty {
    private String id;

    private String userId;

    private String responsibleId;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    private String partyType;

    private String infoAddress;

    private String comment;

    private String mobile;

    private String weixin;

    private String consumeType;

    private String warning;

    private Integer isDel;

}