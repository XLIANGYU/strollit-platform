package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbLoginLog {
    private String id;

    private String userId;

    private Date loginTime;

    private String loginResult;

    private String loginErrorMsg;

    private String loginIp;

    private String loginType;

    private String portalName;

    private String res1;

    private String res2;
    
}