package com.quapt.myf4h.product.persistence.config;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.Assert;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class PersistenceConfigurer {

    @Inject
    private RedisConfig redisConfig; 
    
    @Inject
    private Environment env;
    
    
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
    	Assert.isTrue(redisConfig.getPoolMaxTotal() > 0, "Empty connection pool.");
        JedisConnectionFactory connectionFactory = null;

        if (redisConfig.isClusterEnabled()) {
            connectionFactory = new JedisConnectionFactory(new RedisClusterConfiguration(redisConfig.getNodes()));
        } else {
            connectionFactory = new JedisConnectionFactory();
            connectionFactory.setHostName(redisConfig.getHost());
            connectionFactory.setPort(redisConfig.getPort());
        }

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMinIdle(redisConfig.getPoolInitSize());
        connectionFactory.setPoolConfig(poolConfig);
        connectionFactory.afterPropertiesSet();

        return connectionFactory;
    }
}
