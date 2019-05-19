package com.icefrog.strollit.business.model;

import java.util.Date;

public class TbForumReply {
    private String id;

    private String forum;

    private String replyComment;

    private String replyImg;

    private Integer isRef;

    private String refReplyId;

    private Date createTime;

    private Long floorNum;

    private Integer isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(String replyComment) {
        this.replyComment = replyComment;
    }

    public String getReplyImg() {
        return replyImg;
    }

    public void setReplyImg(String replyImg) {
        this.replyImg = replyImg;
    }

    public Integer getIsRef() {
        return isRef;
    }

    public void setIsRef(Integer isRef) {
        this.isRef = isRef;
    }

    public String getRefReplyId() {
        return refReplyId;
    }

    public void setRefReplyId(String refReplyId) {
        this.refReplyId = refReplyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(Long floorNum) {
        this.floorNum = floorNum;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}