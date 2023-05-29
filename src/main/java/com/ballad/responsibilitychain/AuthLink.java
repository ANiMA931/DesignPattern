package com.ballad.responsibilitychain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * description:
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/5
 * @comment:
 */
public abstract class AuthLink {

    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 级别人员ID
     */
    protected String levelUserId;

    /**
     * 级别人员姓名
     */
    protected String levelUserName;

    /**
     * 责任链
     */
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    /**
     * 获取下一级审批节点
     * @return
     */
    public AuthLink next() {
        return next;
    }

    /**
     * 添加下一级审批节点，并返回本级审批节点
     * 这种审批节点添加方法，在初始化时，先append的节点在审批时会先执行，后添加的会后执行
     * @param next
     * @return
     */
    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    /**
     * 审批操作类
     * @param uId uuid
     * @param orderId 审批单号id
     * @param authDate 审批时间
     * @return
     */
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
