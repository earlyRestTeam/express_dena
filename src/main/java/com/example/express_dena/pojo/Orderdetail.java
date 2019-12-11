package com.example.express_dena.pojo;

import java.io.Serializable;

public class Orderdetail implements Serializable {
    private Integer id;

    private Integer orderid;

    private Float balance;

    private Float kg;

    private String pickUpCode;

    private String courierCompany;

    private String remark1;

    private String remark2;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Float getKg() {
        return kg;
    }

    public void setKg(Float kg) {
        this.kg = kg;
    }

    public String getPickUpCode() {
        return pickUpCode;
    }

    public void setPickUpCode(String pickUpCode) {
        this.pickUpCode = pickUpCode;
    }

    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderid=").append(orderid);
        sb.append(", balance=").append(balance);
        sb.append(", kg=").append(kg);
        sb.append(", pickUpCode=").append(pickUpCode);
        sb.append(", courierCompany=").append(courierCompany);
        sb.append(", remark1=").append(remark1);
        sb.append(", remark2=").append(remark2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}