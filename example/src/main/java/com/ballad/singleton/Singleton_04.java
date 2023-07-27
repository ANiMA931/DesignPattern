package com.ballad.singleton;

/**
 * 使用类的静态内部类实现单例模式，即保证了线程安全，也保证了懒加载，同时也不会有加锁耗时的问题
 * 这主要是因为JVM虚拟机可以保证多线程并发访问的正确性，也就是一个类的构造方法在多线程环境下可以被正确地加载
 * 此种方式也是非常推荐使用的一种方式
 *
 * @author Administrator
 * @Classname Singleton_04
 * @date 2023-06-15 19:37
 * @comment
 */
public class Singleton_04 {

    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }
}
