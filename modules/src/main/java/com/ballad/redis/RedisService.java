package com.ballad.redis;

public interface RedisService {
    void set(String key, Object value);

    Boolean delete(String key);

    Boolean update(String key);

    Object get(String key);

}
