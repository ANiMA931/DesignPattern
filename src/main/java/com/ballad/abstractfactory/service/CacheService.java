package com.ballad.abstractfactory.service;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Classname CacheService
 * @date 2023-06-14 21:00
 * @comment
 */
public interface CacheService {

    String get(final String key);

    void set(String key, String value);

    void set(String key, String value, Long timeout, TimeUnit timeUnit);

    void del(String key);
}
