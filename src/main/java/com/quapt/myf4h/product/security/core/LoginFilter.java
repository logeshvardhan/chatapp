package com.quapt.myf4h.product.security.core;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.GenericFilterBean;

import com.quapt.myf4h.product.core.utill.HttpUtil;
import com.quapt.myf4h.product.security.LoginResult;
import com.quapt.myf4h.product.security.Realm;
import com.quapt.myf4h.product.security.utill.SecurityContextHolder;
import com.quapt.myf4h.product.security.utill.SecurityManager;

public abstract class LoginFilter extends GenericFilterBean {
    private SecurityContextHolder securityContextHolder = SecurityContextHolder.INSTANCE;

    private HttpUtil httpUtil = HttpUtil.INSTANCE;

    protected RoleService roleService;

    @Autowired
    protected SecurityManager manager;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Optional<LoginResult> result = attemptLogin(request, response);

        if (result.isPresent() && result.get().isSuccess()) {
            Realm realm = result.get().getRealm();
            String token = result.get().getToken();
            realm.setRoles(roleService.getRoles(realm.getUserId()));
            manager.storeRealm(token, realm);
            securityContextHolder.setRealm(realm);

            ((HttpServletResponse) response).addCookie(httpUtil.getHttpOnlyCookie("token", token));
        }
        
        chain.doFilter(request, response);
    }

    public abstract Optional<LoginResult> attemptLogin(ServletRequest request, ServletResponse response);

    public LoginFilter setRoleService(RoleService roleService) {
        this.roleService = roleService;
        return this;
    }

}
