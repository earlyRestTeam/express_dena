package com.example.express_dena.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer orderid;

    private String orderno;

    private Integer status;

    private String username;

    private String userTelephone;

    private Float totalAmount;

    private Integer userid;

    private String note;

    private String targetAddress;

    private Integer commentNum;

    private Date createTime;

    private Integer hosermanid;

    private String hosermainPhone;

    private String hosermanName;

    private Date endTime;

    private String remark1;

    private static final long serialVersionUID = 1L;

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getHosermanid() {
        return hosermanid;
    }

    public void setHosermanid(Integer hosermanid) {
        this.hosermanid = hosermanid;
    }

    public String getHosermainPhone() {
        return hosermainPhone;
    }

    public void setHosermainPhone(String hosermainPhone) {
        this.hosermainPhone = hosermainPhone;
    }

    public String getHosermanName() {
        return hosermanName;
    }

    public void setHosermanName(String hosermanName) {
        this.hosermanName = hosermanName;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", orderno=").append(orderno);
        sb.append(", status=").append(status);
        sb.append(", username=").append(username);
        sb.append(", userTelephone=").append(userTelephone);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", userid=").append(userid);
        sb.append(", note=").append(note);
        sb.append(", targetAddress=").append(targetAddress);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", hosermanid=").append(hosermanid);
        sb.append(", hosermainPhone=").append(hosermainPhone);
        sb.append(", hosermanName=").append(hosermanName);
        sb.append(", endTime=").append(endTime);
        sb.append(", remark1=").append(remark1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}