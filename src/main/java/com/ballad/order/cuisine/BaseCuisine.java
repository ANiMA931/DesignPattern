package com.ballad.order.cuisine;

import com.ballad.order.cook.ICook;

/**
 * <p>
 * description: 命令的基类
 * </p>
 *
 * @author: 05697
 * @date: 2022/7/12
 * @comment:
 */
public abstract class BaseCuisine implements ICuisine {

    /**
     * 对于命令基类，需要声明执行命令的客体对象，而该对象必须要有命令的具体实现，所以此处的属性是接口属性，而非类属性
     */
    protected ICook iCook;

    /**
     * 构造函数中，命令基类必须要实现的一点就是将执行本命令的客体对象注入到命令
     * @param iCook
     */
    public BaseCuisine(ICook iCook) {
        this.iCook = iCook;
    }

}
