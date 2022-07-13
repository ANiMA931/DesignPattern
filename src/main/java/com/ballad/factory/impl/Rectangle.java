package com.ballad.factory.impl;

import com.ballad.factory.MyShape;

public class Rectangle extends MyShape {
    @Override
    public void draw() {
        logger.info("Inside Rectangle::draw() method.");
    }
}
