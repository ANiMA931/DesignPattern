package com.ballad.order.cuisine.impl;

import com.ballad.order.cook.ICook;
import com.ballad.order.cuisine.BaseCuisine;

/**
 * <p>
 * description: 某一类命令的实现框架
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public class JiangsuCuisine extends BaseCuisine {

    private final String cuisineName = "江苏菜";

    public JiangsuCuisine(ICook iCook) {
        super(iCook);
    }

    /**
     * 在构造函数阶段，需要将命令的具体实现对象注入到基类的属性中，一般父类的构造函数会设计执行
     */
    @Override
    public void cook() {
        iCook.doCooking(cuisineName);
    }
}
