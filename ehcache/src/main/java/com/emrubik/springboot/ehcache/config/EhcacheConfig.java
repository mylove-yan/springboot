/*******************************************************************************
 * @(#)EhcacheConfig.java 2020/9/3
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.ehcache.config;

import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.impl.serialization.PlainJavaSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * ehcache配置
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/9/3 12:54
 */
@Configuration
public class EhcacheConfig {

    private static final String CACHE_NAME_XXXX = "userCache";
    private static final String CACHE_NAME_YYYY = "shop_service";
    private static final Logger LOGGER = LoggerFactory.getLogger(EhcacheConfig.class);

    public CacheManager ehcacheManager(){
        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder()
                .heap(20, MemoryUnit.MB).offheap(30, MemoryUnit.MB);
        CacheConfiguration<String, Object> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class, resourcePoolsBuilder)
                .withValueSerializer(new PlainJavaSerializer<>(this.getClass().getClassLoader()))
                .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofHours(10))).build();
        org.ehcache.CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
                .withDefaultSizeOfMaxObjectSize(500, MemoryUnit.KB)
                .withDefaultSizeOfMaxObjectGraph(2000)
                .build(true);
        return null;
    }




}
