package com.ordermanager.configs;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPooled;

public class RedisConfig {

    @Value("${redis.connection.host}")
    private String host;

    @Value("${redis.connection.port}")
    private Integer port;

    private JedisPooled pool;

    public RedisConfig() {
        this.setPool();
    }

    private void setPool() {
        new JedisPooled(this.host, this.port);
    }

    public JedisPooled getPool() {
        return this.pool;
    }



}
