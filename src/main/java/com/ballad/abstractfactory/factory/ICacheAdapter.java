package com.ballad.abstractfactory.factory;

import java.util.concurrent.TimeUnit;

/**
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
