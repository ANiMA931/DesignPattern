package com.ballad.adapter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @Classname OrderService
 * @date 2023-06-25 20:18
 * @comment
 */
public class POPOrderService {

    private final Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String uId) {
        logger.info("POP商家，查询用户的订单是否为首单：{}", uId);
        return true;
    }
}
