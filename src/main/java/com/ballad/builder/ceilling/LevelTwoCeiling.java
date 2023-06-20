package com.ballad.builder.ceilling;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * 二级顶
 *
 * @author Administrator
 * @Classname LevelTwoCeiling
 * @date 2023-06-20 19:49
 * @comment
 */
public class LevelTwoCeiling implements Matter {
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
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶的高度一般就往下吊20cm，要是层高很高，也可以增加每级的厚度";
    }
}
