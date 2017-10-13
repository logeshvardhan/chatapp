package com.quapt.myf4h.product.security.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.core.RealmStore;
import com.quapt.myf4h.product.security.utill.SecurityManager;

@ComponentScan(basePackages = "com.quapt.myf4h.product.security")
@Configuration
public class SecurityConfigurer {
    @Autowired
    @Qualifier("RedisRealmStore")
    private RealmStore realmStore;

    @Bean(name = "RedisRealmTemplate")
    public RedisTemplate<String, Realm> redisRealmTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Realm> template = new RedisTemplate<String, Realm>();
        template.setConnectionFactory(connectionFactory);
        Jackson2JsonRedisSerializer<Realm> realmSerializer = new Jackson2JsonRedisSerializer<Realm>(Realm.class);
        StringRedisSerializer keySerializer = new StringRedisSerializer(StandardCharsets.UTF_8);
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        template.setValueSerializer(realmSerializer);
        template.setHashValueSerializer(realmSerializer);
        return template;
    }

    @Bean
    public SecurityManager securityManager() {
        SecurityManager manager = new SecurityManager();
        manager.setStore(realmStore);
        return manager;
    }

}
