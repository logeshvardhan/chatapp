package com.quapt.myf4h.product.security.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.quapt.myf4h.product.core.utill.HttpUtil;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CsrfTokenValidator extends HandlerInterceptorAdapter {
    private static final String CSRF_TOKEN = "CSRF-TOKEN";
    private static final String X_CSRF_TOKEN = "X-CSRF-TOKEN";

    private HttpUtil httpUtil = HttpUtil.INSTANCE;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (httpUtil.isStateChangeRequest(request)) {
            String csrfTokenValue = request.getHeader(X_CSRF_TOKEN);
            Optional<String> csrfCookieValue = httpUtil.readCookie(request, CSRF_TOKEN);

            if (!csrfCookieValue.isPresent() || !csrfCookieValue.get().equals(csrfTokenValue)) {
                throw new SecurityException("csrf.token.mismatch");
            }
        }

        return super.preHandle(request, response, handler);
    }

}
