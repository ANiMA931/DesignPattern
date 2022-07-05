package com.ballad.responsibilitychain.impl;

import com.ballad.responsibilitychain.AuthInfo;
import com.ballad.responsibilitychain.AuthLink;
import com.ballad.responsibilitychain.AuthService;

import java.text.ParseException;
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
public class Level3AuthLink extends AuthLink {

    private final Date beginDate = f.parse("2020-06-11 00:00:00");

    private final Date endDate = f.parse("2020-06-20 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId,levelUserName);
    }


    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：等待三级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批完成负责人 ", " 时间：", f.format(date), " 审批人：", levelUserName);
        }
        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批完成负责人 ", " 时间：", f.format(date), " 审批人：", levelUserName);
        }
        return next.doAuth(uId, orderId, authDate);
    }
}
