package com.quapt.myf4h.product.security.utill;

import java.util.Optional;

import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.core.RealmStore;

public class SecurityManager {

    private RealmStore store;

    public void storeRealm(String authId, Realm realm) {
        store.store(authId, realm);
    }

    public Optional<Realm> getRealm(String authId) {
        return store.get(authId);
    }

    public void removeRealm(String authId) {
        store.remove(authId);
    }

    public void setStore(RealmStore store) {
        this.store = store;
    }

}
