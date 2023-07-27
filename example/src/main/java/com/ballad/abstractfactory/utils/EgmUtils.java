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
public class EgmUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        logger.info("EGM获取数据key: " + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        logger.info("EGM写入数据key: {}, value: {}", key, value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, Long timeout, TimeUnit timeUnit) {
        logger.info("EGM写入数据key: {}, value: {}, timeout: {}, timeUnit: {}", key, value, timeout, timeUnit.toString());
        dataMap.put(key, value);
    }

    public void delete(String key) {
        logger.info("EGM删除数据key: {}", key);
        dataMap.remove(key);
    }


}
