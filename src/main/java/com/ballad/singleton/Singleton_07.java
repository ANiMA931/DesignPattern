package com.ballad.singleton;

/**
 * Effective Java作者给出的枚举单例（线程安全）
 * 此种方式可能是最少用到的
 * 但解决了线程安全、自由串行化，单一实例
 * 此种写法类似共有域，但它更简洁，无偿提供了串行化机制，绝对防止对此实例化，即使面对复杂串行化和反射攻击时，
 * 但此种场景下无法继承
 *
 * @author Administrator
 * @Classname Singleton_07
 * @date 2023-06-15 20:20
 * @comment
 */
public enum Singleton_07 {
    /**
     * 唯一的存在
     */
    INSTANCE;

    public void test() {
        System.out.println("hi~");
    }
}
