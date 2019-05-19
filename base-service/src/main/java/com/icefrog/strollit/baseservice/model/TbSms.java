package com.icefrog.strollit.baseservice.model;

import java.util.Date;

public class TbSms {
    private String id;

    private String num;

    private String templateVal;

    private String serRespCode;

    private String serRespMsg;

    private Date createTime;

    private String result;

    private Integer isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTemplateVal() {
        return templateVal;
    }

    public void setTemplateVal(String templateVal) {
        this.templateVal = templateVal;
    }

    public String getSerRespCode() {
        return serRespCode;
    }

    public void setSerRespCode(String serRespCode) {
        this.serRespCode = serRespCode;
    }

    public String getSerRespMsg() {
        return serRespMsg;
    }

    public void setSerRespMsg(String serRespMsg) {
        this.serRespMsg = serRespMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}