package com.ballad.adapter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Classname OrderService
 * @date 2023-06-25 20:18
 * @comment
 */
public class OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId) {
        logger.info("自营商家，查询用户的订单是否为首单：{}", userId);
        return 10L;
    }
}
