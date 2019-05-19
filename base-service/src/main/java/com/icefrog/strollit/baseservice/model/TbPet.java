package com.icefrog.strollit.baseservice.model;

import java.util.Date;

public class TbPet {
    private String id;

    private String userId;

    private String petTypeId;

    private String petKindId;

    private String petName;

    private Date birthday;

    private String petFaceUrl;

    private String sex;

    private String petColor;

    private String weight;

    private String skill;

    private String remark;

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

    public String getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(String petTypeId) {
        this.petTypeId = petTypeId;
    }

    public String getPetKindId() {
        return petKindId;
    }

    public void setPetKindId(String petKindId) {
        this.petKindId = petKindId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPetFaceUrl() {
        return petFaceUrl;
    }

    public void setPetFaceUrl(String petFaceUrl) {
        this.petFaceUrl = petFaceUrl;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPetColor() {
        return petColor;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}