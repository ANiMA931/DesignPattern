package com.ballad.observer.event.listener;

import com.ballad.observer.LotteryResult;

/**
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
