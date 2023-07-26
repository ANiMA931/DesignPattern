package com.ballad.builder.tile;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname DongPengTile
 * @date 2023-06-20 20:00
 * @comment
 */
public class DongPengTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "东鹏瓷砖";
    }

    @Override
    public String model() {
        return "10001";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(102);
    }

    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌。";
    }
}
