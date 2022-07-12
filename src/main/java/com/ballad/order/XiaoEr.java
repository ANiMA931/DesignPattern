package com.ballad.order;

import com.ballad.order.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * description:
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public class XiaoEr {
    private final Logger logger = LoggerFactory.getLogger(XiaoEr.class);
    private List<ICuisine> iCuisineList = new ArrayList<>();

    public void order(ICuisine cuisine) {
        iCuisineList.add(cuisine);
    }

    public synchronized void placeOrder() {
        for (ICuisine iCuisine : iCuisineList) {
            iCuisine.cook();
        }
        iCuisineList.clear();
    }
}
