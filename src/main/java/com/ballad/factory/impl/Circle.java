package com.ballad.factory.impl;

import com.ballad.factory.MyShape;

public class Circle extends MyShape {
    @Override
    public void draw() {
        logger.info("Inside Circle::draw() method.");
    }
}
