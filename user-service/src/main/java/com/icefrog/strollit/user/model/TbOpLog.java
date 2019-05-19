package com.icefrog.strollit.user.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbOpLog {
    private String id;

    private String userId;

    private String menuName;

    private String portalName;

    private String opType;

    private Date opTime;

    private String remark;
    
}