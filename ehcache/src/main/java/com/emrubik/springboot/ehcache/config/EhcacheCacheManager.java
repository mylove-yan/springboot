/*******************************************************************************
 * @(#)EhcacheCacheManager.java 2020/9/3
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.ehcache.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Arrays;
import java.util.Collection;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/9/3 13:01
 */
public class EhcacheCacheManager implements CacheManager {

    private static final String CACHE_NAME_XXXX = "userCache";

    private static final String CACHE_NAME_YYYY = "shop_service";

    @Override
    public Cache getCache(String s) {


        return new Ehcache(s,null);
    }

    @Override
    public Collection<String> getCacheNames() {
        String[] cacheNames = {CACHE_NAME_XXXX , CACHE_NAME_YYYY};
        return Arrays.asList(cacheNames);
    }
}
