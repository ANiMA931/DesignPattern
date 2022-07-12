package com.ballad.order.cook.impl;

import com.ballad.order.cook.BaseCook;
import com.ballad.order.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * description:
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public class JiangsuCook extends BaseCook {

    private final String cookName = "江苏厨师";
    @Override
    public void doCooking(String cuisineName) {
        logger.info(cookName+"，烹饪"+cuisineName+"。");
    }
}
