package com.quapt.myf4h.product.security.core;

import java.util.Optional;

import com.quapt.myf4h.product.security.Realm;

/**
 * Contract defining strategy for storing authenticated realm.
 * 
 * @author sabir
 *
 */
public interface RealmStore {

    void store(String authId, Realm realm);

    Optional<Realm> get(String authId);

    void remove(String authId);
}
