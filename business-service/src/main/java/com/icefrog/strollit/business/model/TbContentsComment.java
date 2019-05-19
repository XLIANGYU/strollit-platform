package com.icefrog.strollit.business.model;

import java.util.Date;

public class TbContentsComment {
    private String id;

    private String userId;

    private String contentsPushId;

    private String comment;

    private Date createTime;

    private Integer isRef;

    private String refCommentId;

    private String res1;

    private String res2;

    private String res3;

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

    public String getContentsPushId() {
        return contentsPushId;
    }

    public void setContentsPushId(String contentsPushId) {
        this.contentsPushId = contentsPushId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsRef() {
        return isRef;
    }

    public void setIsRef(Integer isRef) {
        this.isRef = isRef;
    }

    public String getRefCommentId() {
        return refCommentId;
    }

    public void setRefCommentId(String refCommentId) {
        this.refCommentId = refCommentId;
    }

    public String getRes1() {
        return res1;
    }

    public void setRes1(String res1) {
        this.res1 = res1;
    }

    public String getRes2() {
        return res2;
    }

    public void setRes2(String res2) {
        this.res2 = res2;
    }

    public String getRes3() {
        return res3;
    }

    public void setRes3(String res3) {
        this.res3 = res3;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}