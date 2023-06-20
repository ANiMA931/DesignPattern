package com.ballad.builder;

import java.math.BigDecimal;

/**
 * 物料，用于模拟抽象建造者模式中的抽象元件
 *
 * @author Administrator
 * @Classname Matter
 * @date 2023-06-20 19:46
 * @comment
 */
public interface Matter {
    /**
     * 场景；地板、地砖、涂料、吊顶
     * @return
     */
    String scene();

    /**
     * 品牌
     * @return
     */
    String brand();

    /**
     * 型号
     * @return
     */
    String model();

    /**
     * 价格
     * @return
     */
    BigDecimal price();

    /**
     * 描述
     * @return
     */
    String desc();
}