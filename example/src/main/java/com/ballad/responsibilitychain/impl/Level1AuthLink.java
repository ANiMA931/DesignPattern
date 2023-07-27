package com.ballad.responsibilitychain.impl;

import com.ballad.responsibilitychain.AuthInfo;
import com.ballad.responsibilitychain.AuthLink;
import com.ballad.responsibilitychain.AuthService;

import java.util.Date;

/**
 * <p>
 * description: 一级责任链实现类
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/5
 * @comment:
 */
public class Level1AuthLink extends AuthLink {
    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        //先依照审批人id与审批单号id查询是否有结果
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        // 若没有结果，表明该审批人尚未审批，直接返回审批信息即可，其中code和infos可以统一在常量类中定义
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：等待第三级审批。\n负责人 ", levelUserName);
        }
        //当有结果时，获取下一级审批节点
        AuthLink next = super.next();
        //若下一级审批节点为null，表明这是最后一级审批，返回审批结果即可
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：第三级审批完成。\n负责人：", levelUserName, "，时间：", f.format(date), "，审批人：", levelUserName);
        }
        //若不为空，则返回下一级的审批结果
        return next.doAuth(uId, orderId, authDate);
    }
}
