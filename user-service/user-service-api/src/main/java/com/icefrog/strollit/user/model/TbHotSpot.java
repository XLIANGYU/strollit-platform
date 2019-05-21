package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbHotSpot {
    private String id;

    private String userId;

    private String hotSpotUserId;

    private Date createTime;

    private Integer isDel;
    
}