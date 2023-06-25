package com.ballad.adapter;

import java.util.Date;

/**
 * @author Administrator
 * @Classname RebateInfo
 * @date 2023-06-25 20:21
 * @comment
 */
public class RebateInfo {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 业务ID
     */
    private String bizId;

    /**
     * 业务时间
     */
    private String bizTime;
    /**
     * 业务描述
     */
    private String desc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getBizTime() {
        return bizTime;
    }

    public void setBizTime(String bizTime) {
        this.bizTime = bizTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
