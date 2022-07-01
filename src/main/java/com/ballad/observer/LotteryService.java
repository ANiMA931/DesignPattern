package com.ballad.observer;

import com.ballad.observer.event.EventManager;
import com.ballad.observer.event.listener.MQEventListener;
import com.ballad.observer.event.listener.MessageEventListener;

/**
 * @author: 05697
 * @date: 2021/10/26
 * @comment: 摇号服务
 */
public abstract class LotteryService {
    private final EventManager eventManager;


    public LotteryService() {
        //摇号服务默认订两种通知服务（消息队列与短信通知）
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);
}