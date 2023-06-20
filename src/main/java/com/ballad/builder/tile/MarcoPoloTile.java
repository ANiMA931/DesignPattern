package com.ballad.builder.tile;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname MarcoPoloTile
 * @date 2023-06-20 20:01
 * @comment
 */
public class MarcoPoloTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "马可波罗";
    }

    @Override
    public String model() {
        return "缺省";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(140);
    }

    @Override
    public String desc() {
        return "马可波罗品牌诞生于1996年，是国内最早品牌化的";
    }
}
