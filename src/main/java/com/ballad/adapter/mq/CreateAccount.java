package com.ballad.adapter.mq;

import java.util.Date;

/**
 * @author Administrator
 * @Classname CreateAccount
 * @date 2023-06-25 20:12
 * @comment
 */
public class CreateAccount {

    /**
     * 开户编号
     */
    private String number;

    /**
     * 开户地
     */
    private String address;
    /**
     * 开户时间
     */
    private Date accountDate;

    /**
     * 开户描述
     */
    private String desc;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(Date accountDate) {
        this.accountDate = accountDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "CreateAccount{" +
                "number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", accountDate=" + accountDate +
                ", desc='" + desc + '\'' +
                '}';
    }
}
