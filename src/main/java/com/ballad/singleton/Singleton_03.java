package com.ballad.singleton;

/**
 * 此种方式与00的方式相似，在程序启动的时候加载，后续有外部使用的时候直接获取即可；
 * 但此种方式是饿汉模式，程序中无论会不会使用，此单例都会创建；
 *
 * @author Administrator
 * @Classname Singleton_03
 * @date 2023-06-15 19:27
 * @comment
 */
public class Singleton_03 {

    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {
    }

    public static Singleton_03 getInstance() {
        return instance;
    }

}
