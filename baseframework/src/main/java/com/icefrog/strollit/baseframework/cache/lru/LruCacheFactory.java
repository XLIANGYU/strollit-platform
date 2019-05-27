/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.cache.lru;

import com.icefrog.strollit.baseframework.cache.AbstractCacheFactory;
import com.icefrog.strollit.baseframework.cache.Cache;
import com.icefrog.strollit.baseframework.cache.CacheConstant;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LruCacheFactory extends AbstractCacheFactory {

    private static LruCacheFactory instance = null;

    public static LruCacheFactory getInstance() {
        if (instance == null) {
            synchronized (LruCacheFactory.class) {
                if (instance == null) {
                    instance = new LruCacheFactory();
                }
            }
        }
        return instance;
    }

    @Override
    protected Cache createCache(String cacheKey) {
        int cacheLength = extractCacheLength(cacheKey);
        return new LruCache(cacheLength);
    }

    private int extractCacheLength(String cacheKey) {
        String[] keys = cacheKey.split(CacheConstant.LRU_KEY_SEPARATOR);
        int cacheLength;
        if (keys.length < CacheConstant.LRU_KEY_ARRAY_LENGTH) {
            return CacheConstant.LRU_DEFAULT_LENGTH;
        }
        try {
            cacheLength = Integer.valueOf(keys[1]);
        } catch (NumberFormatException e) {
            log.error( "redis create key format exception, key="+cacheKey+"", e);
            cacheLength = CacheConstant.LRU_DEFAULT_LENGTH;
        }
        return cacheLength;
    }
}
