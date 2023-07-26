package com.ballad.factory.impl;

import com.ballad.factory.MyShape;

/**
 * 形状实现类（三角形）
 */
public class Rectangle extends MyShape {


    /**
     * 实现三角形形状的绘画方法
     */
    @Override
    public void draw() {
        logger.info("Inside Rectangle::draw() method.");
    }
}
