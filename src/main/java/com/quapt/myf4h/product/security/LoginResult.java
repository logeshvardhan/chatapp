package com.quapt.myf4h.product.security;

import org.springframework.util.Assert;

public final class LoginResult {
    private boolean success;

    private String token;

    private Realm realm;

    public void setSuccess(String token, Realm realm) {
        Assert.noNullElements(new Object[] { token, realm }, "Must provide token and realm for login success case.");
        this.token = token;
        this.realm = realm;
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public Realm getRealm() {
        return realm;
    }

}
