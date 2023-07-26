package com.ballad.order.cook.impl;

import com.ballad.order.cook.BaseCook;

/**
 * <p>
 * description: 具体的命令实现类
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public class ShandongCook extends BaseCook {
    private final String cookName = "山东厨师";

    @Override
    public void doCooking(String cuisine) {
        logger.info(cookName+"，烹饪"+cuisine+"。");
    }
}
