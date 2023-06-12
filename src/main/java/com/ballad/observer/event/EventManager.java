package com.ballad.observer.event;

import com.ballad.observer.LotteryResult;
import com.ballad.observer.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件监听管理类
 *
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public class EventManager {
    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();


    /**
     * 事件监听管理类构造方法，将需要注册监听的枚举注入到列表中
     * @param operations
     */
    @SafeVarargs
    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * 事件类型枚举类
     */
    public enum EventType {
        /**
         * 订阅消息队列
         */
        MQ,
        /**
         * 订阅短信
         */
        Message
    }

    /**
     * 订阅方法
     * 将某个实现了监听的对象添加到管理类的列表中
     *
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     * 将某个实现类监听类的对象从管理类的列表中移除
     *
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     *
     * @param eventType 事件类型
     * @param result    结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }
}