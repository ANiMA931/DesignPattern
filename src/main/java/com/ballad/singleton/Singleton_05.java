package com.ballad.singleton;

/**
 * 双重校验锁
 * 双重锁的方式是方法级锁的优化，减少了部分获取实例的耗时
 * 这种方式也满足了懒加载
 *
 * @author Administrator
 * @Classname Singleton_05
 * @date 2023-06-15 19:49
 * @comment
 */
public class Singleton_05 {

    private static Singleton_05 instance;

    private Singleton_05() {
    }

    public static Singleton_05 getInstance() {
        if (null != instance) {
            return instance;
        }
        synchronized (Singleton_05.class) {
            if (null == instance) {
                instance = new Singleton_05();
            }
        }
        return instance;
    }

}
