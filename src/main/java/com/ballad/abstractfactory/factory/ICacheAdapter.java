package com.ballad.abstractfactory.factory;

import java.util.concurrent.TimeUnit;

/**
 * 适配接口，调用原理相同但方法名不同的服务时，屏蔽服务差别所用
 * 具体的接口方法，则来自适配方的方法，在本案例中指CacheService
 *
 * @author Administrator
 * @Classname ICacheAdapter
 * @date 2023-06-14 21:07
 * @comment
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key, String value);

    void set(String key, String value, Long timeout, TimeUnit timeUnit);

    void del(String key);
}
