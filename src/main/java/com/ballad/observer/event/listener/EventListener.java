package com.ballad.observer.event.listener;

import com.ballad.observer.LotteryResult;

/**
 * 事件监听接口，引入接口的类都需要实现事件方法
 *
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public interface EventListener {
    /**
     * 订阅事件
     * @param result
     */
    void doEvent(LotteryResult result);
}
