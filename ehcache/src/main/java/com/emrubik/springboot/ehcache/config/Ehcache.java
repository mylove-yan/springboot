/*******************************************************************************
 * @(#)Ehcache.java 2020/9/3
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.ehcache.config;

import org.ehcache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/9/3 13:05
 */
public class Ehcache implements Cache {

    private static final Logger LOGGER = LoggerFactory.getLogger(EhcacheConfig.class);

    private String name;

    private org.ehcache.CacheManager cacheManager;

    private org.ehcache.Cache<String, Object> heapEhcache = cacheManager.getCache(name, String.class, Object.class);

    public Ehcache(String name, CacheManager cacheManager) {
        this.name = name;
        this.cacheManager = cacheManager;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getNativeCache() {
        return heapEhcache;
    }

    @Override
    public ValueWrapper get(Object key) {
        Object value = heapEhcache.get(String.valueOf(key));
        return null == value ? null : () -> value;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        Object value = heapEhcache.get(String.valueOf(key));
        if (value != null && type != null && !type.isInstance(value)) {
            throw new IllegalStateException("Cached value is not of required type [" + type.getName() + "]: " + value);
        }
        return (T) value;
    }

    @Override
    public <T> T get(Object o, Callable<T> valueLoader) {
        try {
            return valueLoader.call();
        } catch (Exception e) {
            LOGGER.error("ehcache valueLoader.call occur error", e);
        }
        return null;
    }

    @Override
    public void put(Object key, Object value) {
        heapEhcache.put(String.valueOf(key), value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        Object putIfAbsent = heapEhcache.putIfAbsent(String.valueOf(key), value);
        return putIfAbsent == null ? null : () -> putIfAbsent;
    }


    @Override
    public void evict(Object key) {
        heapEhcache.remove(String.valueOf(key));
    }

    @Override
    public void clear() {
        heapEhcache.clear();
    }
}
