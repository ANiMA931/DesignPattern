package com.ballad.abstractfactory.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @Classname StandaloneUtils
 * @date 2023-06-14 20:50
 * @comment
 */
public class IIRUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        logger.info("IIR获取数据key: " + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("IIR写入数据key: {}, value: {}", key, value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, Long timeout, TimeUnit timeUnit) {
        logger.info("IIR写入数据key: {}, value: {}, timeout: {}, timeUnit: {}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void del(String key) {
        logger.info("IIR删除数据key: {}", key);
        dataMap.remove(key);
    }


}
