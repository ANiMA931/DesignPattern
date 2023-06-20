package com.ballad.builder.floor;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname ShengXiangFloor
 * @date 2023-06-20 19:58
 * @comment
 */
public class ShengXiangFloor implements Matter {
    @Override
    public String scene() {
        return "地板";
    }

    @Override
    public String brand() {
        return "圣象";
    }

    @Override
    public String model() {
        return "一级";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(318);
    }

    @Override
    public String desc() {
        return "圣象地板是中国地板行业著名品牌。";
    }
}
