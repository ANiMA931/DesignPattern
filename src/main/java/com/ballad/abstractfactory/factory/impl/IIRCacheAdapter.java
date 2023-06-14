package com.ballad.abstractfactory.factory.impl;

import com.ballad.abstractfactory.factory.ICacheAdapter;
import com.ballad.abstractfactory.utils.IIRUtils;

import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Classname IIRCacheAdapter
 * @date 2023-06-14 21:07
 * @comment
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIRUtils iirUtils = new IIRUtils();

    @Override
    public String get(String key) {
        return iirUtils.get(key);
    }

    @Override
    public void set(String key, String value) {
        iirUtils.set(key, value);
    }

    @Override
    public void set(String key, String value, Long timeout, TimeUnit timeUnit) {
        iirUtils.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iirUtils.del(key);
    }
}
