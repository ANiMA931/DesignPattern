package com.ballad.factory.impl;

import com.ballad.factory.MyShape;

/**
 * 形状实现类（方框）
 */
public class Square extends MyShape {


    /**
     * 实现方框形状的绘画方法
     */
    @Override
    public void draw() {
        logger.info("Inside Square::draw() method.");
    }
}
