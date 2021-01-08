package com.f1soft.zuul.fonepay.config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

@Slf4j
@Configuration
public class HazelcastConfig {

    @Bean
    public CacheManager hazelCastCacheManager() {
        return new HazelcastCacheManager(Hazelcast.getOrCreateHazelcastInstance());
    }

    @Bean
    public javax.cache.CacheManager javaxCacheManager() {
        CachingProvider cachingProvider = Caching.getCachingProvider();
        return cachingProvider.getCacheManager();
    }
}
