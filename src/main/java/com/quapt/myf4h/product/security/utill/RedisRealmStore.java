package com.quapt.myf4h.product.security.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.core.RealmStore;

import java.util.Optional;

import javax.annotation.PostConstruct;

@Component("RedisRealmStore")
public class RedisRealmStore implements RealmStore {
    private static final String COLLECTION_NAME = "RealmStore";

    @Autowired
    @Qualifier("RedisRealmTemplate")
    private RedisTemplate<String, Realm> template;

    private HashOperations<String, String, Realm> operations;

    @PostConstruct
    protected void init() {
        operations = template.opsForHash();
    }

    public void store(String authId, Realm realm) {
        Assert.noNullElements(new Object[] { authId, realm }, "either authId or realm is null");
        operations.put(COLLECTION_NAME, authId, realm);
    }

    public Optional<Realm> get(String authId) {
        Assert.notNull(authId, "authId is null");
        Realm realm = operations.get(COLLECTION_NAME, authId);
        return Optional.ofNullable(realm);
    }

    public void remove(String authId) {
        Assert.notNull(authId, "authId is null");
        operations.delete(COLLECTION_NAME, authId);
    }
}
