package com.sailfish.cache.redis.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author XIAXINYU3
 * @date 2020/11/30
 */
@Component
public class RedisUtils {
    RedisTemplate<Object, Object> redisTemplate;

    public RedisUtils(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 根据起始结束序号遍历Redis中的list
     *
     * @param key   键
     * @param value 数据项
     * @param score 分数
     * @return
     */
    public void add(String key, String value, long score) {
        redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 根据起始结束序号遍历Redis中的list
     *
     * @param key   键
     * @param start 起始
     * @param end   结束
     * @return
     */
    public Set<Object> rangeByScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeByScore(key, start, end);
    }

    /**
     * 根据起始结束序号遍历Redis中的list
     *
     * @param key   键
     * @param start 起始
     * @param end   结束
     * @return
     */
    public Long count(String key, long start, long end) {
        return redisTemplate.opsForZSet().count(key, start, end);
    }

    /**
     * 根据起始结束序号遍历Redis中的list
     *
     * @param key   键
     * @param value 数据项
     * @return
     */
    public Long zrem(String key, String value) {
        return redisTemplate.opsForZSet().remove(key, value);
    }

    /**
     * 设置key
     *
     * @param key     键
     * @param value   数据项
     * @param timeout 超时时间
     * @param unit    时间单位
     */
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        if (hasKey(key)) {
            redisTemplate.delete(key);
        }
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 根据key获取数据
     *
     * @param key
     */
    public String get(String key) {
        if (hasKey(key)) {
            return (String) redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除key
     *
     * @param key 键
     * @return true/false
     */
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}