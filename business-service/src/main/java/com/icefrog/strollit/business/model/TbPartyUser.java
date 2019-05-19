package com.icefrog.strollit.business.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbPartyUser {
    private String id;

    private String partyId;

    private String userId;

    private Date createTime;

    private Integer isDel;

}