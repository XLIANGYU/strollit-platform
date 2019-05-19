package com.icefrog.strollit.user.model;

import java.util.Date;

public class TbHotSpot {
    private String id;

    private String userId;

    private String hotSpotUserId;

    private Date createTime;

    private Integer isDel;

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

    public String getHotSpotUserId() {
        return hotSpotUserId;
    }

    public void setHotSpotUserId(String hotSpotUserId) {
        this.hotSpotUserId = hotSpotUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}