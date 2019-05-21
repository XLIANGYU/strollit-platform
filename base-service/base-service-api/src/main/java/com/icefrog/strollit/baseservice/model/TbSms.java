package com.icefrog.strollit.baseservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class TbSms {
    private String id;

    private String num;

    private String templateVal;

    private String serRespCode;

    private String serRespMsg;

    private Date createTime;

    private String result;

    private Integer isDel;
    
}