package com.ballad.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象类（形状）
 * 但具体的形状则需要具体的实现，
 * 此处需要具体实现的部分则由各继承了该抽象类的类实现，
 * 理论上讲，继承了该抽象类才能够被称为 形状
 */
public abstract class MyShape {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 抽象方法 ”绘画“，表示继承了该抽象类的子类都应实现此绘画方法；
     */
    public abstract void draw();
}
