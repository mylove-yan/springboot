package com.emrubik.springboot.springbootshiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import javax.annotation.Resource;

/**
 * @author chengchenrui
 * @version Id: RedisCacheManager.java, v 0.1 2018/6/29 1:13 chengchenrui Exp $$
 */
public class RedisCacheManager implements CacheManager {

    @Resource
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}