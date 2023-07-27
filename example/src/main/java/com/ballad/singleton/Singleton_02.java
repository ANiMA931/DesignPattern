package com.ballad.singleton;

/**
 * 此种模式虽然安全，但是由于把锁加到了方法上，所有的访问都会占用锁导致资源浪费
 * 如果不是特殊情况下，不建议用此种方式实现单例模式
 *
 * @author Administrator
 * @Classname Singleton_02
 * @date 2023-06-15 19:25
 * @comment
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance() {
        if (null != instance) {
            return instance;
        }
        instance = new Singleton_02();
        return instance;
    }

}
