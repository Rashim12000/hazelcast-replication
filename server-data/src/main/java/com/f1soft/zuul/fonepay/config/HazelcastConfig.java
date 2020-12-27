package com.f1soft.zuul.fonepay.config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class HazelcastConfig {

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(Hazelcast.getOrCreateHazelcastInstance());
    }
}
