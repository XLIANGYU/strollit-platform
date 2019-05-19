package com.icefrog.strollit.baseframework.cache.lru;

import com.icefrog.strollit.baseframework.cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LruCache<K, V> implements Cache<K, V> {

    private LinkedHashMap<K, V> map;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public LruCache(int maxLength) {
        map = new LinkedHashMap<K, V>(100, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Entry<K, V> eldest) {
                if (maxLength == 0){
                    return false;
                }
                if (size() > maxLength && eldest.getValue() instanceof IDestroyAble) {
                    ((IDestroyAble) eldest.getValue()).destroy();
                }
                return size() > maxLength;
            }
        };
    }

    /**
     * 添加项
     *
     * @param item 项
     * @param state 状态
     */
    @Override
    public void put(K item, V state) {
        lock.writeLock().lock();
        map.put(item, state);
        lock.writeLock().unlock();
    }

    /**
     * 获取值,使用前请判断是否存在item
     *
     * @param item 项
     * @return value 值
     */
    @Override
    public V get(K item) {
        lock.readLock().lock();
        V value = map.get(item);
        lock.readLock().unlock();
        return value;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    /**
     * 是否存在
     *
     * @param item 项
     * @return 是否存在
     */
    @Override
    public boolean containsKey(K item) {
        lock.readLock().lock();
        boolean isContainer = map.containsKey(item);
        lock.readLock().unlock();
        return isContainer;
    }

    /**
     * 删除item
     *
     * @param item 项
     */
    @Override
    public void remove(K item) {
        lock.writeLock().lock();
        map.remove(item);
        lock.writeLock().unlock();
    }
}