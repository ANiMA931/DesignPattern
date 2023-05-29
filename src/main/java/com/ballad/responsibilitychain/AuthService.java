package com.ballad.responsibilitychain;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * description: 审批服务类
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/5
 * @comment:
 */
public class AuthService {
    /**
     * 审批map，用于模拟数据库存储的已审批信息
     */
    private static final Map<String, Date> authMap = new ConcurrentHashMap<>();

    /**
     * 查询审批信息
     * @param uId
     * @param orderId
     * @return
     */
    public static Date queryAuthInfo(String uId, String orderId) {
        //从map中取，模拟从数据库中查询审批信息的方法
        return authMap.get(uId.concat(orderId));
    }

    /**
     * 审批方法
     * @param uId
     * @param orderId
     */
    public static void auth(String uId, String orderId) {
        //将用户id+审批单号id作为key存到静态map中，用于模拟向数据库中存储此次审批信息，其中new的date对象用来代表审批实体
        authMap.put(uId.concat(orderId), new Date());
    }
}
