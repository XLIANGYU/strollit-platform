/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class AbstractCacheFactory {

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();

    public Cache getCache(String key) {
        Cache cache = caches.get(key);
        if (cache == null) {
            caches.put(key, createCache(key));
            cache = caches.get(key);
        }
        return cache;
    }

    protected abstract Cache createCache(String key);
}
