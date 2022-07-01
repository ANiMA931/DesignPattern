package com.ballad.observer;

import java.util.Date;

/**
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public class LotteryResult {
    private String id;
    private String msg;
    private Date date;

    public LotteryResult(String id, String msg, Date date) {
        this.id = id;
        this.msg = msg;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
