package com.icefrog.strollit.business.model;

import java.util.Date;

public class TbSell {
    private String id;

    private String userId;

    private String productName;

    private String originPrice;

    private String sellPrice;

    private String moneyType;

    private String buySrc;

    private Integer isInvoce;

    private Date createTime;

    private String status;

    private Integer isDel;

    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getBuySrc() {
        return buySrc;
    }

    public void setBuySrc(String buySrc) {
        this.buySrc = buySrc;
    }

    public Integer getIsInvoce() {
        return isInvoce;
    }

    public void setIsInvoce(Integer isInvoce) {
        this.isInvoce = isInvoce;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}