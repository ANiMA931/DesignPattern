package com.ballad.order;

import com.ballad.order.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * description: 小二，即命令的调用者
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

    /**
     * 对于命令列表，须要同步执行，列表的清理操作需要保证其原子性
     */
    public synchronized void placeOrder() {
        for (ICuisine iCuisine : iCuisineList) {
            iCuisine.cook();
        }
        iCuisineList.clear();
    }
}
