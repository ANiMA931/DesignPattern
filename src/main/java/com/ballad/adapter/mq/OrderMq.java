package com.ballad.adapter.mq;

import java.util.Date;

/**
 * @author Administrator
 * @Classname OrderMq
 * @date 2023-06-25 20:14
 * @comment
 */
public class OrderMq {

    /**
     * 用户id
     */
    private String uid;
    /**
     * 商品
     */
    private String sku;
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 下单时间
     */
    private Date createOrderTime;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateOrderTime() {
        return createOrderTime;
    }

    public void setCreateOrderTime(Date createOrderTime) {
        this.createOrderTime = createOrderTime;
    }

    @Override
    public String toString() {
        return "OrderMq{" +
                "uid='" + uid + '\'' +
                ", sku='" + sku + '\'' +
                ", orderId='" + orderId + '\'' +
                ", createOrderTime=" + createOrderTime +
                '}';
    }
}
