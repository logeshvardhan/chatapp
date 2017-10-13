package com.quapt.myf4h.product.security.interceptor;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.quapt.myf4h.product.core.utill.HttpUtil;
import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.config.LoginConfig;
import com.quapt.myf4h.product.security.core.AuthenticationException;
import com.quapt.myf4h.product.security.utill.SecurityContextHolder;
import com.quapt.myf4h.product.security.utill.SecurityManager;

@Component
public class AuthenticationTokenVerifier extends HandlerInterceptorAdapter {

    @Autowired
    private LoginConfig loginConfig;

    @Autowired
    private SecurityManager manager;

    private HttpUtil httpUtil = HttpUtil.INSTANCE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Optional<Realm> realm = getRealm(request);

        if (realm.isPresent() && realm.get().isAuthenticated()) {
            SecurityContextHolder.INSTANCE.setRealm(realm.get());
        } else {
            throw new AuthenticationException("unauthenticated.request");
        }

        return true;
    }

    private Optional<Realm> getRealm(HttpServletRequest request) {
        Optional<Realm> realm = Optional.empty();
        Optional<String> token = httpUtil.readCookie(request, loginConfig.getTokenParameter());

        if (token.isPresent()) {
            realm = manager.getRealm(token.get());
        }

        return realm;
    }

}
