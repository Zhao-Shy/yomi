package com.zhaoshy.yomi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhaoshy
 * @License: (C) Copyright 2016-2999, xxx Corporation Limited.
 * @Contact: zsyfaith@163.com
 * @Date: 2020-01-23 17:12
 * @Version: 1.0
 * @Description: Redis 集群方法缓存
 */

@Configuration
public class RedisCacheConfig {
    @Autowired
    RedisConnectionFactory factory;
    @Bean
    RedisCacheManager redisCacheManager() {
        Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
        RedisCacheConfiguration redisCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                                                .prefixKeysWith("sang:").disableCachingNullValues()
                                                .entryTtl(Duration.ofMinutes(30));
        configurationMap.put("c1", redisCacheConfig);
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(factory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter,
                                        RedisCacheConfiguration.defaultCacheConfig(), configurationMap);
        return redisCacheManager;
    }
}
