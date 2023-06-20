package com.ballad.builder.floor;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname DerFloor
 * @date 2023-06-20 19:57
 * @comment
 */
public class DerFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "德尔";
    }

    @Override
    public String model() {
        return "A+";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(119);
    }

    @Override
    public String desc() {
        return "der集团是全球领先的地板制造商。";
    }
}
