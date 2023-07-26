package com.ballad.adapter.impl;

import com.ballad.adapter.OrderAdapterService;
import com.ballad.adapter.service.OrderService;

/**
 * @author Administrator
 * @Classname InsideOrderService
 * @date 2023-06-25 20:21
 * @comment
 */
public class InsideOrderServiceImpl implements OrderAdapterService {

    private final OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
