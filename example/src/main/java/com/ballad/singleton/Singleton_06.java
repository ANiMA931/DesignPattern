package com.ballad.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS AtomicReference 线程安全
 * java并发库提供了很多原子类来支持并发访问的数据安全性：AtomicInteger、AtomicBoolean、AtomicLong、AtomicReference。。。
 * AtomicReference可以封装引用一个V实例，支持并发访问如下的单例方式就是用了这种特点
 * 使用CAS的好处就是不需要使用传统的加锁方式保证线程安全，而是依赖于CAS的忙等算法，依赖于底层硬件的实现来保证线程安全
 * 相对于其他锁，没有线程切换与阻塞也就没有了额外的开销，并且可以支持较大的并发性
 * 而CAS的缺点就是忙等，如果一直没有获取到，那就会处于死循环中。
 *
 * @author Administrator
 * @Classname Singleton_06
 * @date 2023-06-15 19:52
 * @comment
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();
    private static Singleton_06 instance;

    private Singleton_06() {
    }

    public static final Singleton_06 getInstance() {
        for (; ; ) {
            Singleton_06 instance = INSTANCE.get();
            if (null != instance) {
                return instance;
            }
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }

}
