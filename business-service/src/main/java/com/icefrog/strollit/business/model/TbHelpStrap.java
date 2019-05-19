package com.icefrog.strollit.business.model;

import java.util.Date;

public class TbHelpStrap {
    private String id;

    private String userId;

    private String petId;

    private Date createTime;

    private Date updateTime;

    private Date startTime;

    private Date endTime;

    private Integer isUrgent;

    private Integer isUsePetInfo;

    private String petImgList;

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

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(Integer isUrgent) {
        this.isUrgent = isUrgent;
    }

    public Integer getIsUsePetInfo() {
        return isUsePetInfo;
    }

    public void setIsUsePetInfo(Integer isUsePetInfo) {
        this.isUsePetInfo = isUsePetInfo;
    }

    public String getPetImgList() {
        return petImgList;
    }

    public void setPetImgList(String petImgList) {
        this.petImgList = petImgList;
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