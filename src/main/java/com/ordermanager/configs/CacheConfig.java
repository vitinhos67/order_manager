package com.ordermanager.configs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        // configure and return an implementation of Spring's CacheManager SPI
        SimpleCacheManager cacheManager = new SimpleCacheManager();


        List<ConcurrentMapCache> caches = new ArrayList();
        caches.add(new ConcurrentMapCache("users"));
        caches.add(new ConcurrentMapCache("orders"));
        caches.add(new ConcurrentMapCache("itens"));

        cacheManager.setCaches(caches);
        return cacheManager;
    }

}
