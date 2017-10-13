package com.quapt.myf4h.product.persistence.config;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = PersistenceConfigurer.class, initializers = PersistenceYamlInitializer.class)
public class TestRedisConfig {

    @Inject
    private RedisConfig config;
	
	@Value("${redis.config.host}")
    private String redisHostName;

    @Value("${redis.config.port}")
    private int redisPort;

    @Test
    public void shouldCheckRedisConfig() {
    	System.out.println("Testing,.,");
        //Assert.hasText(config.getHost(), "host not configured");
    }
}
