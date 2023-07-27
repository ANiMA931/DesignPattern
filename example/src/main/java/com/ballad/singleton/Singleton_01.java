package com.ballad.singleton;

/**
 * 单例模式不允许外部创建，所以构造函数为私有属性
 * 目前虽然实现了懒加载，但线程不安全，当多个线程访问到getInstance的时候，就有可能产生多个实例，不满足单例模式的情形
 *
 * @author Administrator
 * @Classname Singleton_01
 * @date 2023-06-15 19:11
 * @comment
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        if (null != instance) {
            return instance;
        }
        instance = new Singleton_01();
        return instance;
    }
}
