package com.example.express_dena.pojo;

import java.io.Serializable;

public class Withdrawals implements Serializable {
    private Integer id;

    private Float withdrawalsBalance;

    private Integer horsemanid;

    private String accounts;

    private Integer type;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getWithdrawalsBalance() {
        return withdrawalsBalance;
    }

    public void setWithdrawalsBalance(Float withdrawalsBalance) {
        this.withdrawalsBalance = withdrawalsBalance;
    }

    public Integer getHorsemanid() {
        return horsemanid;
    }

    public void setHorsemanid(Integer horsemanid) {
        this.horsemanid = horsemanid;
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", withdrawalsBalance=").append(withdrawalsBalance);
        sb.append(", horsemanid=").append(horsemanid);
        sb.append(", accounts=").append(accounts);
        sb.append(", type=").append(type);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}