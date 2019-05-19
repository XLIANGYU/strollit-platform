package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbRole {
    private String id;

    private String updateId;

    private String createId;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private String remark;

    private Integer isDel;
    
}