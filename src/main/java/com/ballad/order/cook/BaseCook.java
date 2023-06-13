package com.ballad.order.cook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * description: 命令执行者基类，继承本基类的子类必须要实现执行命令的方法
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public abstract class BaseCook implements ICook {
    /**
     * 基类的属性大多都是各个子类都能用得上的东西
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
