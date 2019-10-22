package com.stranger.camping.campingproductclient.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisConnection {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(20);
        config.setMinIdle(5);
        jedisPool = new JedisPool(config, "127.0.0.1", 6379);
    }

    public static Jedis getJedis(){
        if (jedisPool!=null) {
            Jedis jedis = jedisPool.getResource();
            return jedis;
        }
        return null;
    }
}
