package com.ballad.order.cook;

import com.ballad.order.cuisine.ICuisine;

/**
 * <p>
 * description: 厨师，即命令的具体实现方法
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public interface ICook {
    /**
     * 烹饪接口方法
     */
    void doCooking(String cuisine);
}
