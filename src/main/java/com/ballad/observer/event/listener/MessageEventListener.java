package com.ballad.observer.event.listener;

import com.ballad.observer.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 短信事件监听类
 *
 * @author: 05697
 * @date: 2021/10/26
 * @comment:
 */
public class MessageEventListener extends BaseEventListener {
    @Override
    public void doEvent(LotteryResult result) {
        logger.info("给⽤户 {} 发送短信通知(短信)：{}", result.getId(), result.getMsg());
    }
}
