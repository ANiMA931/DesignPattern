package com.ballad.observer.event.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * description:
 * </p>
 *
 * @author: 05697
 * @date: 2022/6/30
 * @comment:
 */
public abstract class BaseEventListener implements EventListener {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
