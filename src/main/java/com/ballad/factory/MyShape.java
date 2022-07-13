package com.ballad.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class MyShape {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    public abstract void draw();
}
