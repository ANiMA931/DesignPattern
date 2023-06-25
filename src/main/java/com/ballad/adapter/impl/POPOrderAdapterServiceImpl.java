package com.ballad.adapter.impl;

import com.ballad.adapter.OrderAdapterService;
import com.ballad.adapter.service.OrderService;
import com.ballad.adapter.service.POPOrderService;

/**
 * @author Administrator
 * @Classname InsideOrderService
 * @date 2023-06-25 20:21
 * @comment
 */
public class POPOrderAdapterServiceImpl implements OrderAdapterService {

    private final POPOrderService orderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.isFirstOrder(uId);
    }
}
