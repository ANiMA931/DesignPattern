package com.ballad.factory.impl;

import com.ballad.factory.MyShape;


/**
 * 形状实现类（圆形）
 */
public class Circle extends MyShape {


    /**
     * 实现原型形状的绘画方法
     */
    @Override
    public void draw() {
        logger.info("Inside Circle::draw() method.");
    }
}
