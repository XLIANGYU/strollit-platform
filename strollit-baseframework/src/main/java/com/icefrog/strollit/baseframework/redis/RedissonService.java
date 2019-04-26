/*
 * frxs Inc.  兴盛社区网络服务股份有限公司.
 * Copyright (c) 2017-2018. All Rights Reserved.
 */

package com.icefrog.strollit.baseframework.redis;

import java.util.concurrent.TimeUnit;
import org.redisson.api.ClusterNodesGroup;
import org.redisson.api.LocalCachedMapOptions;
import org.redisson.api.MapOptions;
import org.redisson.api.Node;
import org.redisson.api.NodesGroup;
import org.redisson.api.RAtomicDouble;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBatch;
import org.redisson.api.RBinaryStream;
import org.redisson.api.RBitSet;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RBoundedBlockingQueue;
import org.redisson.api.RBucket;
import org.redisson.api.RBuckets;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RDeque;
import org.redisson.api.RGeo;
import org.redisson.api.RHyperLogLog;
import org.redisson.api.RKeys;
import org.redisson.api.RLexSortedSet;
import org.redisson.api.RList;
import org.redisson.api.RListMultimap;
import org.redisson.api.RListMultimapCache;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RLocalCachedMap;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RPatternTopic;
import org.redisson.api.RPermitExpirableSemaphore;
import org.redisson.api.RPriorityDeque;
import org.redisson.api.RPriorityQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RRemoteService;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RScript;
import org.redisson.api.RSemaphore;
import org.redisson.api.RSet;
import org.redisson.api.RSetCache;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RSetMultimapCache;
import org.redisson.api.RSortedSet;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.ReferenceCodecProvider;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

/**
 * Redission 操作redis数据
 */
@Service("redissonService")
@ConditionalOnClass(RedissonClient.class)
public class RedissonService {

    @Autowired(required = false)
    private RedissonClient redissonClient;

    /**
     * Returns binary stream holder instance by <code>name</code>
     *
     * @param name of binary stream
     * @return BinaryStream object
     */
    public RBinaryStream getBinaryStream(String name) {
        return redissonClient.getBinaryStream(name);
    }

    /**
     * Returns geospatial items holder instance by <code>name</code>.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return Geo object
     */
    public <V> RGeo<V> getGeo(String name) {
        return redissonClient.getGeo(name);
    }

    /**
     * Returns geospatial items holder instance by <code>name</code> using provided codec for
     * geospatial members.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for value
     * @return Geo object
     */
    public <V> RGeo<V> getGeo(String name, Codec codec) {
        return redissonClient.getGeo(name, codec);
    }

    /**
     * Returns set-based cache instance by <code>name</code>. Supports value eviction with a given TTL
     * value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link #getSet(String,
     * Codec)}.</p>
     *
     * @param <V> type of value
     * @param name - name of object
     * @return SetCache object
     */
    public <V> RSetCache<V> getSetCache(String name) {
        return redissonClient.getSetCache(name);
    }

    /**
     * Returns set-based cache instance by <code>name</code>. Supports value eviction with a given TTL
     * value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link #getSet(String,
     * Codec)}.</p>
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return SetCache object
     */
    public <V> RSetCache<V> getSetCache(String name, Codec codec) {
        return redissonClient.getSetCache(name, codec);
    }

    /**
     * Returns map-based cache instance by <code>name</code> using provided <code>codec</code> for
     * both cache keys and values. Supports entry eviction with a given MaxIdleTime and TTL settings.
     * <p> If eviction is not required then it's better to use regular map {@link #getMap(String,
     * Codec)}.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - object name
     * @param codec - codec for keys and values
     * @return MapCache object
     */
    public <K, V> RMapCache<K, V> getMapCache(String name, Codec codec) {
        return redissonClient.getMapCache(name, codec);
    }

    /**
     * Returns map-based cache instance by <code>name</code> using provided <code>codec</code> for
     * both cache keys and values. Supports entry eviction with a given MaxIdleTime and TTL settings.
     * <p> If eviction is not required then it's better to use regular map {@link #getMap(String,
     * Codec)}.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - object name
     * @param codec - codec for keys and values
     * @param options - map options
     * @return MapCache object
     */
    public <K, V> RMapCache<K, V> getMapCache(String name, Codec codec, MapOptions<K, V> options) {
        return redissonClient.getMapCache(name, codec, options);
    }

    /**
     * Returns map-based cache instance by name. Supports entry eviction with a given MaxIdleTime and
     * TTL settings. <p> If eviction is not required then it's better to use regular map {@link
     * #getMap(String)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return MapCache object
     */
    public <K, V> RMapCache<K, V> getMapCache(String name) {
        return redissonClient.getMapCache(name);
    }

    /**
     * Returns map-based cache instance by name. Supports entry eviction with a given MaxIdleTime and
     * TTL settings. <p> If eviction is not required then it's better to use regular map {@link
     * #getMap(String)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param options - map options
     * @return MapCache object
     */
    public <K, V> RMapCache<K, V> getMapCache(String name, MapOptions<K, V> options) {
        return redissonClient.getMapCache(name, options);
    }

    /**
     * Returns object holder instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return Bucket object
     */
    public <V> RBucket<V> getBucket(String name) {
        return redissonClient.getBucket(name);
    }

    /**
     * Returns object holder instance by name using provided codec for object.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return Bucket object
     */
    public <V> RBucket<V> getBucket(String name, Codec codec) {
        return redissonClient.getBucket(name, codec);
    }

    /**
     * Returns interface for mass operations with Bucket objects.
     *
     * @return Buckets
     */
    public RBuckets getBuckets() {
        return redissonClient.getBuckets();
    }

    /**
     * Returns interface for mass operations with Bucket objects using provided codec for object.
     *
     * @param codec - codec for bucket objects
     * @return Buckets
     */
    public RBuckets getBuckets(Codec codec) {
        return redissonClient.getBuckets(codec);
    }

    /**
     * Returns HyperLogLog instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return HyperLogLog object
     */
    public <V> RHyperLogLog<V> getHyperLogLog(String name) {
        return redissonClient.getHyperLogLog(name);
    }

    /**
     * Returns HyperLogLog instance by name using provided codec for hll objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return HyperLogLog object
     */
    public <V> RHyperLogLog<V> getHyperLogLog(String name, Codec codec) {
        return redissonClient.getHyperLogLog(name, codec);
    }

    /**
     * Returns list instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return List object
     */
    public <V> RList<V> getList(String name) {
        return redissonClient.getList(name);
    }

    /**
     * Returns list instance by name using provided codec for list objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return List object
     */
    public <V> RList<V> getList(String name, Codec codec) {
        return redissonClient.getList(name, codec);
    }

    /**
     * Returns List based Multimap instance by name.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return ListMultimap object
     */
    public <K, V> RListMultimap<K, V> getListMultimap(String name) {
        return redissonClient.getListMultimap(name);
    }

    /**
     * Returns List based Multimap instance by name using provided codec for both map keys and
     * values.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @return ListMultimap object
     */
    public <K, V> RListMultimap<K, V> getListMultimap(String name, Codec codec) {
        return redissonClient.getListMultimap(name, codec);
    }

    /**
     * Returns List based Multimap instance by name. Supports key-entry eviction with a given TTL
     * value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link
     * #getSetMultimap(String)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return ListMultimapCache object
     */
    public <K, V> RListMultimapCache<K, V> getListMultimapCache(String name) {
        return redissonClient.getListMultimapCache(name);
    }

    /**
     * Returns List based Multimap instance by name using provided codec for both map keys and values.
     * Supports key-entry eviction with a given TTL value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link
     * #getSetMultimap(String, Codec)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @return ListMultimapCache object
     */
    public <K, V> RListMultimapCache<K, V> getListMultimapCache(String name, Codec codec) {
        return redissonClient.getListMultimapCache(name, codec);
    }

    /**
     * Returns local cached map instance by name. Configured by parameters of options-object.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param options - local map options
     * @return LocalCachedMap object
     */
    public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String name,
        LocalCachedMapOptions<K, V> options) {
        return redissonClient.getLocalCachedMap(name, options);
    }

    /**
     * Returns local cached map instance by name using provided codec. Configured by parameters of
     * options-object.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @param options - local map options
     * @return LocalCachedMap object
     */
    public <K, V> RLocalCachedMap<K, V> getLocalCachedMap(String name, Codec codec,
        LocalCachedMapOptions<K, V> options) {
        return redissonClient.getLocalCachedMap(name, codec, options);
    }

    /**
     * Returns map instance by name.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return Map object
     */
    public <K, V> RMap<K, V> getMap(String name) {
        return redissonClient.getMap(name);
    }

    /**
     * Returns map instance by name.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param options - map options
     * @return Map object
     */
    public <K, V> RMap<K, V> getMap(String name, MapOptions<K, V> options) {
        return redissonClient.getMap(name, options);
    }

    /**
     * Returns map instance by name using provided codec for both map keys and values.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @return Map object
     */
    public <K, V> RMap<K, V> getMap(String name, Codec codec) {
        return redissonClient.getMap(name, codec);
    }

    /**
     * Returns map instance by name using provided codec for both map keys and values.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @param options - map options
     * @return Map object
     */
    public <K, V> RMap<K, V> getMap(String name, Codec codec, MapOptions<K, V> options) {
        return redissonClient.getMap(name, codec, options);
    }

    /**
     * Returns Set based Multimap instance by name.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return SetMultimap object
     */
    public <K, V> RSetMultimap<K, V> getSetMultimap(String name) {
        return redissonClient.getSetMultimap(name);
    }

    /**
     * Returns Set based Multimap instance by name using provided codec for both map keys and values.
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @return SetMultimap object
     */
    public <K, V> RSetMultimap<K, V> getSetMultimap(String name, Codec codec) {
        return redissonClient.getSetMultimap(name, codec);
    }

    /**
     * Returns Set based Multimap instance by name. Supports key-entry eviction with a given TTL
     * value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link
     * #getSetMultimap(String)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @return SetMultimapCache object
     */
    public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String name) {
        return redissonClient.getSetMultimapCache(name);
    }

    /**
     * Returns Set based Multimap instance by name using provided codec for both map keys and values.
     * Supports key-entry eviction with a given TTL value.
     *
     * <p>If eviction is not required then it's better to use regular map {@link
     * #getSetMultimap(String, Codec)}.</p>
     *
     * @param <K> type of key
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for keys and values
     * @return SetMultimapCache object
     */
    public <K, V> RSetMultimapCache<K, V> getSetMultimapCache(String name, Codec codec) {
        return redissonClient.getSetMultimapCache(name, codec);
    }

    /**
     * Returns semaphore instance by name
     *
     * @param name - name of object
     * @return Semaphore object
     */
    public RSemaphore getSemaphore(String name) {
        return redissonClient.getSemaphore(name);
    }

    /**
     * Returns semaphore instance by name. Supports lease time parameter for each acquired permit.
     *
     * @param name - name of object
     * @return PermitExpirableSemaphore object
     */
    public RPermitExpirableSemaphore getPermitExpirableSemaphore(String name) {
        return redissonClient.getPermitExpirableSemaphore(name);
    }

    /**
     * Returns lock instance by name. <p> Implements a <b>non-fair</b> locking so doesn't guarantees
     * an acquire order by threads.
     *
     * @param name - name of object
     * @return Lock object
     */
    public RLock getLock(String name) {
        return redissonClient.getLock(name);
    }

    /**
     * Returns lock instance by name. <p> Implements a <b>fair</b> locking so it guarantees an acquire
     * order by threads.
     *
     * @param name - name of object
     * @return Lock object
     */
    public RLock getFairLock(String name) {
        return redissonClient.getFairLock(name);
    }

    /**
     * Returns readWriteLock instance by name.
     *
     * @param name - name of object
     * @return Lock object
     */
    public RReadWriteLock getReadWriteLock(String name) {
        return redissonClient.getReadWriteLock(name);
    }

    /**
     * Returns set instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return Set object
     */
    public <V> RSet<V> getSet(String name) {
        return redissonClient.getSet(name);
    }

    /**
     * Returns set instance by name using provided codec for set objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return Set object
     */
    public <V> RSet<V> getSet(String name, Codec codec) {
        return redissonClient.getSet(name, codec);
    }

    /**
     * Returns sorted set instance by name. This sorted set uses comparator to sort objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return SortedSet object
     */
    public <V> RSortedSet<V> getSortedSet(String name) {
        return redissonClient.getSortedSet(name);
    }

    /**
     * Returns sorted set instance by name using provided codec for sorted set objects. This sorted
     * set sorts objects using comparator.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return SortedSet object
     */
    public <V> RSortedSet<V> getSortedSet(String name, Codec codec) {
        return redissonClient.getSortedSet(name, codec);
    }

    /**
     * Returns Redis Sorted Set instance by name. This sorted set sorts objects by object score.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return ScoredSortedSet object
     */
    public <V> RScoredSortedSet<V> getScoredSortedSet(String name) {
        return redissonClient.getScoredSortedSet(name);
    }

    /**
     * Returns Redis Sorted Set instance by name using provided codec for sorted set objects. This
     * sorted set sorts objects by object score.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return ScoredSortedSet object
     */
    public <V> RScoredSortedSet<V> getScoredSortedSet(String name, Codec codec) {
        return redissonClient.getScoredSortedSet(name, codec);
    }

    /**
     * Returns String based Redis Sorted Set instance by name All elements are inserted with the same
     * score during addition, in order to force lexicographical ordering
     *
     * @param name - name of object
     * @return LexSortedSet object
     */
    public RLexSortedSet getLexSortedSet(String name) {
        return redissonClient.getLexSortedSet(name);
    }

    /**
     * Returns topic instance by name.
     *
     * @param <M> type of message
     * @param name - name of object
     * @return Topic object
     */
    public <M> RTopic getTopic(String name) {
        return redissonClient.getTopic(name);
    }

    /**
     * Returns topic instance by name using provided codec for messages.
     *
     * @param <M> type of message
     * @param name - name of object
     * @param codec - codec for message
     * @return Topic object
     */
    public <M> RTopic getTopic(String name, Codec codec) {
        return redissonClient.getTopic(name, codec);
    }

    /**
     * Returns topic instance satisfies by pattern name.
     *
     * Supported glob-style patterns: h?llo subscribes to hello, hallo and hxllo h*llo subscribes to
     * hllo and heeeello h[ae]llo subscribes to hello and hallo, but not hillo
     *
     * @param <M> type of message
     * @param pattern of the topic
     * @return PatterTopic object
     */
    public <M> RPatternTopic getPatternTopic(String pattern) {
        return redissonClient.getPatternTopic(pattern);
    }

    /**
     * Returns topic instance satisfies by pattern name using provided codec for messages.
     *
     * Supported glob-style patterns: h?llo subscribes to hello, hallo and hxllo h*llo subscribes to
     * hllo and heeeello h[ae]llo subscribes to hello and hallo, but not hillo
     *
     * @param <M> type of message
     * @param pattern of the topic
     * @param codec - codec for message
     * @return PatterTopic object
     */
    public <M> RPatternTopic getPatternTopic(String pattern, Codec codec) {
        return redissonClient.getPatternTopic(pattern, codec);
    }

    /**
     * Returns unbounded queue instance by name.
     *
     * @param <V> type of value
     * @param name of object
     * @return queue object
     */
    public <V> RQueue<V> getQueue(String name) {
        return getQueue(name);
    }

    /**
     * Returns unbounded delayed queue instance by name. <p> Could be attached to destination queue
     * only. All elements are inserted with transfer delay to destination queue.
     *
     * @param <V> type of value
     * @param destinationQueue - destination queue
     * @return Delayed queue object
     */
    public <V> RDelayedQueue<V> getDelayedQueue(RQueue<V> destinationQueue) {
        return getDelayedQueue(destinationQueue);
    }

    /**
     * Returns unbounded queue instance by name using provided codec for queue objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for message
     * @return Queue object
     */
    public <V> RQueue<V> getQueue(String name, Codec codec) {
        return redissonClient.getQueue(name, codec);
    }

    /**
     * Returns priority unbounded queue instance by name. It uses comparator to sort objects.
     *
     * @param <V> type of value
     * @param name of object
     * @return Queue object
     */
    public <V> RPriorityQueue<V> getPriorityQueue(String name) {
        return redissonClient.getPriorityQueue(name);
    }

    /**
     * Returns priority unbounded queue instance by name using provided codec for queue objects. It
     * uses comparator to sort objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for message
     * @return Queue object
     */
    public <V> RPriorityQueue<V> getPriorityQueue(String name, Codec codec) {
        return redissonClient.getPriorityQueue(name, codec);
    }

    /**
     * Returns priority unbounded deque instance by name. It uses comparator to sort objects.
     *
     * @param <V> type of value
     * @param name of object
     * @return Queue object
     */
    public <V> RPriorityDeque<V> getPriorityDeque(String name) {
        return redissonClient.getPriorityDeque(name);
    }

    /**
     * Returns priority unbounded deque instance by name using provided codec for queue objects. It
     * uses comparator to sort objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for message
     * @return Queue object
     */
    public <V> RPriorityDeque<V> getPriorityDeque(String name, Codec codec) {
        return redissonClient.getPriorityDeque(name, codec);
    }

    /**
     * Returns unbounded blocking queue instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return BlockingQueue object
     */
    public <V> RBlockingQueue<V> getBlockingQueue(String name) {
        return redissonClient.getBlockingQueue(name);
    }

    /**
     * Returns unbounded blocking queue instance by name using provided codec for queue objects.
     *
     * @param <V> type of value
     * @param name - name of queue
     * @param codec - queue objects codec
     * @return BlockingQueue object
     */
    public <V> RBlockingQueue<V> getBlockingQueue(String name, Codec codec) {
        return redissonClient.getBlockingQueue(name, codec);
    }

    /**
     * Returns bounded blocking queue instance by name.
     *
     * @param <V> type of value
     * @param name of queue
     * @return BoundedBlockingQueue object
     */
    public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String name) {
        return redissonClient.getBoundedBlockingQueue(name);
    }

    /**
     * Returns bounded blocking queue instance by name using provided codec for queue objects.
     *
     * @param <V> type of value
     * @param name - name of queue
     * @param codec - codec for values
     * @return BoundedBlockingQueue object
     */
    public <V> RBoundedBlockingQueue<V> getBoundedBlockingQueue(String name, Codec codec) {
        return redissonClient.getBoundedBlockingQueue(name, codec);
    }

    /**
     * Returns unbounded deque instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return Deque object
     */
    public <V> RDeque<V> getDeque(String name) {
        return redissonClient.getDeque(name);
    }

    /**
     * Returns unbounded deque instance by name using provided codec for deque objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return Deque object
     */
    public <V> RDeque<V> getDeque(String name, Codec codec) {
        return redissonClient.getDeque(name, codec);
    }

    /**
     * Returns unbounded blocking deque instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return BlockingDeque object
     */
    public <V> RBlockingDeque<V> getBlockingDeque(String name) {
        return redissonClient.getBlockingDeque(name);
    }

    /**
     * Returns unbounded blocking deque instance by name using provided codec for deque objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - deque objects codec
     * @return BlockingDeque object
     */
    public <V> RBlockingDeque<V> getBlockingDeque(String name, Codec codec) {
        return redissonClient.getBlockingDeque(name, codec);
    }

    /**
     * Returns atomicLong instance by name.
     *
     * @param name - name of object
     * @return AtomicLong object
     */
    public RAtomicLong getAtomicLong(String name) {
        return redissonClient.getAtomicLong(name);
    }

    /**
     * Returns atomicDouble instance by name.
     *
     * @param name - name of object
     * @return AtomicDouble object
     */
    public RAtomicDouble getAtomicDouble(String name) {
        return redissonClient.getAtomicDouble(name);
    }

    /**
     * Returns countDownLatch instance by name.
     *
     * @param name - name of object
     * @return CountDownLatch object
     */
    public RCountDownLatch getCountDownLatch(String name) {
        return redissonClient.getCountDownLatch(name);
    }

    /**
     * Returns bitSet instance by name.
     *
     * @param name - name of object
     * @return BitSet object
     */
    public RBitSet getBitSet(String name) {
        return redissonClient.getBitSet(name);
    }

    /**
     * Returns bloom filter instance by name.
     *
     * @param <V> type of value
     * @param name - name of object
     * @return BloomFilter object
     */
    public <V> RBloomFilter<V> getBloomFilter(String name) {
        return redissonClient.getBloomFilter(name);
    }

    /**
     * Returns bloom filter instance by name using provided codec for objects.
     *
     * @param <V> type of value
     * @param name - name of object
     * @param codec - codec for values
     * @return BloomFilter object
     */
    public <V> RBloomFilter<V> getBloomFilter(String name, Codec codec) {
        return redissonClient.getBloomFilter(name, codec);
    }

    /**
     * Returns script operations object
     *
     * @return Script object
     */
    public RScript getScript() {
        return redissonClient.getScript();
    }

    /**
     * Returns ScheduledExecutorService by name
     *
     * @param name - name of object
     * @return ScheduledExecutorService object
     */
    public RScheduledExecutorService getExecutorService(String name) {
        return redissonClient.getExecutorService(name);
    }

    /**
     * Returns ScheduledExecutorService by name using provided codec for task, response and request
     * serialization
     *
     * @param name - name of object
     * @param codec - codec for task, response and request
     * @return ScheduledExecutorService object
     * @since 2.8.2
     */
    public RScheduledExecutorService getExecutorService(String name, Codec codec) {
        return redissonClient.getExecutorService(name, codec);
    }

    /**
     * Returns object for remote operations prefixed with the default name (redisson_remote_service)
     *
     * @return RemoteService object
     */
    public RRemoteService getRemoteService() {
        return redissonClient.getRemoteService();
    }

    /**
     * Returns object for remote operations prefixed with the default name (redisson_remote_service)
     * and uses provided codec for method arguments and result.
     *
     * @param codec - codec for response and request
     * @return RemoteService object
     */
    public RRemoteService getRemoteService(Codec codec) {
        return redissonClient.getRemoteService(codec);
    }

    /**
     * Returns object for remote operations prefixed with the specified name
     *
     * @param name - the name used as the Redis key prefix for the services
     * @return RemoteService object
     */
    public RRemoteService getRemoteService(String name) {
        return redissonClient.getRemoteService(name);
    }

    /**
     * Returns object for remote operations prefixed with the specified name and uses provided codec
     * for method arguments and result.
     *
     * @param name - the name used as the Redis key prefix for the services
     * @param codec - codec for response and request
     * @return RemoteService object
     */
    public RRemoteService getRemoteService(String name, Codec codec) {
        return redissonClient.getRemoteService(name, codec);
    }

    /**
     * Return batch object which executes group of command in pipeline.
     *
     * See <a href="http://redis.io/topics/pipelining">http://redis.io/topics/pipelining</a>
     *
     * @return Batch object
     */
    public RBatch createBatch() {
        return redissonClient.createBatch();
    }

    /**
     * Returns interface with methods for Redis keys. Each of Redis/Redisson object associated with
     * own key
     *
     * @return Keys object
     */
    public RKeys getKeys() {
        return redissonClient.getKeys();
    }

    /**
     * Returns RedissonAttachedLiveObjectService which can be used to retrieve live REntity(s)
     *
     * @return LiveObjectService object
     */
    public RLiveObjectService getLiveObjectService() {
        return redissonClient.getLiveObjectService();
    }

    /**
     * Shutdown Redisson instance but <b>NOT</b> Redis server
     *
     * This equates to invoke shutdown(2, 15, TimeUnit.SECONDS);
     */
    public void shutdown() {
        redissonClient.shutdown();
    }

    /**
     * Shuts down Redisson instance <b>NOT</b> Redis server
     *
     * Shutdown ensures that no tasks are submitted for <i>'the quiet period'</i> (usually a couple
     * seconds) before it shuts itself down.  If a task is submitted during the quiet period, it is
     * guaranteed to be accepted and the quiet period will start over.
     *
     * @param quietPeriod the quiet period as described in the documentation
     * @param timeout the maximum amount of time to wait until the executor is {@linkplain
     * #shutdown()} regardless if a task was submitted during the quiet period
     * @param unit the unit of {@code quietPeriod} and {@code timeout}
     */
    public void shutdown(long quietPeriod, long timeout, TimeUnit unit) {
        redissonClient.shutdown(quietPeriod, timeout, unit);
    }

    /**
     * Allows to get configuration provided during Redisson instance creation. Further changes on this
     * object not affect Redisson instance.
     *
     * @return Config object
     */
    public Config getConfig() {
        return redissonClient.getConfig();
    }

    /**
     * Get Redis nodes group for server operations
     *
     * @return NodesGroup object
     */
    public NodesGroup<Node> getNodesGroup() {
        return redissonClient.getNodesGroup();
    }

    /**
     * Get Redis cluster nodes group for server operations
     *
     * @return ClusterNodesGroup object
     */
    public ClusterNodesGroup getClusterNodesGroup() {
        return redissonClient.getClusterNodesGroup();
    }
}
