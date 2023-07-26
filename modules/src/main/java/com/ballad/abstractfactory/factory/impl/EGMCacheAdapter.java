package com.ballad.abstractfactory.factory.impl;

import com.ballad.abstractfactory.factory.ICacheAdapter;
import com.ballad.abstractfactory.utils.EgmUtils;

import java.util.concurrent.TimeUnit;

/**
 * 适配接口的具体实现，针对某一需要适配的服务实现接口方法
 *
 * @author Administrator
 * @Classname EGMCacheAdapter
 * @date 2023-06-14 21:07
 * @comment
 */
public class EGMCacheAdapter implements ICacheAdapter {

    /**
     * 需要适配的服务
     */
    private EgmUtils egmUtils = new EgmUtils();

    @Override
    public String get(String key) {
        return egmUtils.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egmUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        egmUtils.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egmUtils.delete(key);
    }
}
