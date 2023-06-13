package com.ballad.order.cook.impl;

import com.ballad.order.cook.BaseCook;
import com.ballad.order.cook.ICook;
import com.ballad.order.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * description: 某个具体执行命令的子类
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public class GuangdongCook extends BaseCook {
    private final String cookName = "广东厨师";

    /**
     * 某项命令具体如何执行的方法
     * @param cuisine 需要执行的命令
     */
    @Override
    public void doCooking(String cuisine) {
        //此处便可以对命令进行操作
        logger.info(cookName+"，烹饪"+cuisine+"。");
    }
}
