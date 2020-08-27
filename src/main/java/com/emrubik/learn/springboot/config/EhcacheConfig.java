/*******************************************************************************
 * @(#)EhcacheConfig.java 2020/8/27
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.config;

import org.aspectj.lang.annotation.Before;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.impl.serialization.PlainJavaSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/8/27 19:59
 */
@Configuration
@EnableCaching // 开启缓存注解
public class EhcacheConfig {
    //https://blog.51cto.com/881206524/2320745?source=dra
    //https://www.bbsmax.com/A/gAJGgAw1JZ/
    private static final String CACHE_NAME_XXXX = "userCache";
    private static final String CACHE_NAME_YYYY = "shop_service";
    private static final Logger LOGGER = LoggerFactory.getLogger(EhcacheConfig.class);

    @Bean
    public CacheManager cacheManager() {
        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(20, MemoryUnit.MB).offheap(30, MemoryUnit.MB);
        CacheConfiguration<String, Object> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, resourcePoolsBuilder)
                .withValueSerializer(new PlainJavaSerializer<>(this.getClass().getClassLoader()))
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofHours(10))).build();
        org.ehcache.CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withDefaultSizeOfMaxObjectSize(500, MemoryUnit.KB)
                .withDefaultSizeOfMaxObjectGraph(2000)
                .withCache(CACHE_NAME_XXXX, cacheConfiguration)
                .withCache(CACHE_NAME_YYYY, cacheConfiguration)
                .build(true);

        return new CacheManager() {
            @Override
            public Cache getCache(String name) {
                org.ehcache.Cache<String, Object> heapEhcache = cacheManager.getCache(name, String.class, Object.class);
                return new Cache() {
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
                };

            }

            @Override
            public Collection<String> getCacheNames() {
                String[] cacheNames = {CACHE_NAME_XXXX , CACHE_NAME_YYYY};
                return Arrays.asList(cacheNames);
            }
        };

    }

}
