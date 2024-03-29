package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbUser {
    private String id;

    private String roleId;

    private String provindeId;

    private String cityId;

    private String countyId;

    private String townId;

    private String account;

    private String nickName;

    private String passwd;

    private String salt;

    private String faceUrl;

    private String wxToken;

    private String infoAddress;

    private String sex;
    
    private String createId;
    
    private String updateId;
    
    private Date createTime;
    
    private Date updateTime;

    private Integer isDestory;

    private Integer isDisable;

    private Integer isDel;
    
}