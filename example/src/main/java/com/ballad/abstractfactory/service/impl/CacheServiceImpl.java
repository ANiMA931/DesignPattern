package com.ballad.abstractfactory.service.impl;

import com.ballad.abstractfactory.service.CacheService;
import com.ballad.abstractfactory.utils.StandaloneRedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Classname CacheServiceImpl
 * @date 2023-06-14 21:01
 * @comment
 */
public class CacheServiceImpl implements CacheService {

    private StandaloneRedisUtils redisUtils = new StandaloneRedisUtils();

    @Override
    public String get(String key) {
        return redisUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        redisUtils.set(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtils.del(key);
    }
}
