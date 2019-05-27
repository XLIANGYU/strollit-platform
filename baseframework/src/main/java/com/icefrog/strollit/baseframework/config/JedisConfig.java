/*
 * Copyright 2019 zoohub.cn All rights reserved.
 *
 * @since 1.0
 * @author: icefrog.su@qq.com
 */

package com.icefrog.strollit.baseframework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis Pool 配置类
 */
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "spring.redis.jedis.single", name = "enabled")
@Import(RedisProperties.class)
public class JedisConfig {

    /**
     * Configuration properties for Redis
     */
    @Autowired
    private RedisProperties redisProperties;

    @Bean("jedisPool")
    public JedisPool redisPoolFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());
        jedisPoolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        jedisPoolConfig
            .setMaxWaitMillis(redisProperties.getJedis().getPool().getMaxWait().toMillis());
        jedisPoolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(),
            redisProperties.getPort(), redisProperties.getTimeout().getNano(),
            redisProperties.getPassword(), redisProperties.getDatabase());
        // 注册jvm关闭钩子 关闭redissonClient
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!jedisPool.isClosed()) {
                jedisPool.close();
                log.info("jedisPool close !!!");
            }
        }));
        return jedisPool;
    }
}
