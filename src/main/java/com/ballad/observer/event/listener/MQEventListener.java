package com.ballad.observer.event.listener;

import com.ballad.observer.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public class MQEventListener implements EventListener {
    private final Logger logger = LoggerFactory.getLogger(MQEventListener.class);
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("记录⽤户 {} 摇号结果(MQ)：{}", result.getId(), result.getMsg());
    }
}
