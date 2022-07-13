package com.ballad.factory.impl;

import com.ballad.factory.MyShape;

public class Square extends MyShape {
    @Override
    public void draw() {
        logger.info("Inside Square::draw() method.");
    }
}
