/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.cache;

import java.util.Set;

public interface Cache<K, V> {

    void put(K var1, V var2);

    Object get(K var1);

    Set<K> keySet();

    /**
     * 是否存在
     *
     * @param item 项
     * @return 是否存在
     */
    boolean containsKey(K item);

    /**
     * 删除item
     *
     * @param item 项
     */
    void remove(K item);
}
