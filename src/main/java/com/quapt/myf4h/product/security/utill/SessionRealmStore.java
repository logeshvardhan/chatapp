package com.quapt.myf4h.product.security.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.core.RealmStore;

import java.util.Optional;

import javax.servlet.http.HttpSession;

@Component("SessionRealmStore")
public class SessionRealmStore implements RealmStore {

    @Autowired(required = false)
    private HttpSession session;

    public void store(String authId, Realm realm) {
        Assert.noNullElements(new Object[] { authId, realm }, "either authId or realm is null");
        session.invalidate();
        session.setAttribute(authId, realm);
    }

    public Optional<Realm> get(String authId) {
        Assert.notNull(authId, "authId is null");
        Realm realm = (Realm) session.getAttribute(authId);
        return Optional.ofNullable(realm);
    }

    public void remove(String authId) {
        Assert.notNull(authId, "authId is null");
        session.removeAttribute(authId);
    }
}
