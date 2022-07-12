package com.ballad.order.cuisine.impl;

import com.ballad.order.cook.BaseCook;
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
public class GuangdongCuisine extends BaseCuisine {

    private final String cuisineName = "广东菜";

    public GuangdongCuisine(BaseCook iCook) {
        super(iCook);
    }

    @Override
    public void cook() {
        iCook.doCooking(cuisineName);
    }
}
