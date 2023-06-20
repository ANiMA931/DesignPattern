package com.ballad.builder.ceilling;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * 一级顶
 *
 * @author Administrator
 * @Classname LevelOneCeiling
 * @date 2023-06-20 19:47
 * @comment
 */
public class LevelOneCeiling implements Matter {
    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "一级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(260);
    }

    @Override
    public String desc() {
        return "造型只做低一级，只有一个层次的吊顶，一般离顶120-150mm";
    }
}
