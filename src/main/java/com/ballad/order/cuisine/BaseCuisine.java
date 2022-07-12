package com.ballad.order.cuisine;

import com.ballad.order.cook.ICook;

/**
 * <p>
 * description:
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public abstract class BaseCuisine implements ICuisine {

    protected ICook iCook;
    public BaseCuisine(ICook iCook){
        this.iCook = iCook;
    }

}
