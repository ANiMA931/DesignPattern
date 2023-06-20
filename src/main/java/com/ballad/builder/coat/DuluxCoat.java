package com.ballad.builder.coat;

import com.ballad.builder.Matter;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @Classname DuluxCoat
 * @date 2023-06-20 19:52
 * @comment
 */
public class DuluxCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "多乐士Dulux";
    }

    @Override
    public String model() {
        return "第二代";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(719);
    }

    @Override
    public String desc() {
        return "多乐士是阿克苏诺贝尔旗下的著名建筑装饰油漆品牌，产品畅销于全球100多个国家和地区，每年全球有5000万户家庭使用。";
    }
}
