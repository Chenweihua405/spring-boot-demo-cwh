package org.example;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈卫华
 * @date 2024/11/22
 */
@Configuration
public class CacheConfig {

    @Primary
    @Bean("customCacheManager")
    public CacheManager customCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<Cache> cacheList = new ArrayList<>();
        cacheList.add(customCache());
        simpleCacheManager.setCaches(cacheList);
        return simpleCacheManager;
    }

    public Cache customCache() {
        return new CaffeineCache("customCache", Caffeine.newBuilder()
                .maximumSize(200)
                .initialCapacity(100)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .recordStats()
                .build(),
                true);
    }

    public Cache customCache2() {
        return new CaffeineCache("customCache2", Caffeine.newBuilder()
                .maximumSize(100)
                .initialCapacity(10)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .recordStats()
                .build(),
                true);
    }

    @Bean("otherCacheManager")
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                // 设置过期时间，写入后五分钟国企
                .expireAfterWrite(5, TimeUnit.MINUTES)
                // 初始化缓存空间大小
                .initialCapacity(100)
                // 最大的缓存条数
                .maximumSize(200));
        return cacheManager;
    }

}

