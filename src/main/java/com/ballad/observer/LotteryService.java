package com.ballad.observer;

import com.ballad.observer.event.EventManager;
import com.ballad.observer.event.listener.MQEventListener;
import com.ballad.observer.event.listener.MessageEventListener;

/**
 * 摇号服务抽象类
 *
 * @author: 05697
 * @date: 2021/10/26
 * @comment: 摇号服务
 */
public abstract class LotteryService {
    private final EventManager eventManager;


    /**
     * 抽象方法构造类，摇号服务抽象类需要在构造函数中实现事件监听类的中注册，以及通知方式的初始化
     */
    public LotteryService() {
        //摇号服务默认订两种通知服务（消息队列与短信通知）
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    /**
     * 摇号方法，此为摇号类的外层业务方法
     * @param uId
     * @return
     */
    public LotteryResult draw(String uId) {
        //首先模拟获取摇号结果，此摇号结果如何产生的由摇号服务的具体实现类实现
        LotteryResult lotteryResult = doDraw(uId);
        //而摇号结果则可以通过选择不同的通知类来决定通知方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        //最后返回摇号得到的内容
        return lotteryResult;
    }

    /**
     * 摇号服务类的真核心业务方法，需要具体的类继承该摇号服务类实现
     * @param uId
     * @return
     */
    protected abstract LotteryResult doDraw(String uId);
}