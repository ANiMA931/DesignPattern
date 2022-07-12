package com.ballad.order.cuisine.impl;

import com.ballad.order.cook.ICook;
import com.ballad.order.cuisine.BaseCuisine;

/**
 * <p>
 * description:
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

    @Override
    public void cook() {
        iCook.doCooking(cuisineName);
    }
}
