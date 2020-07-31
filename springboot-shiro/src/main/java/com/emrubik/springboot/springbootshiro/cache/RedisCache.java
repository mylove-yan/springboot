package com.emrubik.springboot.springbootshiro.cache;

import com.emrubik.springboot.springbootshiro.utils.JedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.Set;

/**
 * @author chengchenrui
 * @version Id: RedisCache.java, v 0.1 2018/6/29 1:15 chengchenrui Exp $$
 */
public class RedisCache<K, V> implements Cache<K, V> {

    private final String CACHE_PREFIX = "shiro-cache";

    @Autowired
    private JedisUtil jedisUtil;

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Override
    public V get(K k) throws CacheException {
        System.out.println("从Redis中获取权限数据");
        byte[] value = jedisUtil.get(getKey(k));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(key);
        jedisUtil.del(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }
    //清空整个缓存
    @Override
    public void clear() throws CacheException {

    }
    //返回缓存大小
    @Override
    public int size() {
        return 0;
    }

    //获取缓存中所有的key
    @Override
    public Set<K> keys() {
        return null;
    }
    //获取缓存中所有的value
    @Override
    public Collection<V> values() {
        return null;
    }


}