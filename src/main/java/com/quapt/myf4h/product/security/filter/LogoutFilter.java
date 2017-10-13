package com.quapt.myf4h.product.security.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.filter.GenericFilterBean;

import com.quapt.myf4h.product.core.response.RestResponse;
import com.quapt.myf4h.product.core.type.ResponseType;
import com.quapt.myf4h.product.core.utill.HttpUtil;
import com.quapt.myf4h.product.core.utill.JsonConverter;
import com.quapt.myf4h.product.security.config.LoginConfig;
import com.quapt.myf4h.product.security.utill.SecurityManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogoutFilter extends GenericFilterBean {

    @Autowired
    private SecurityManager manager;

    @Autowired
    private LoginConfig loginConfig;

    private JsonConverter jsonConverter = JsonConverter.INSTANCE;

    private HttpUtil httpUtil = HttpUtil.INSTANCE;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Optional<String> token = httpUtil.readCookie((HttpServletRequest) request, loginConfig.getTokenParameter());

        if (token.isPresent()) {
            manager.removeRealm(token.get());

            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            RestResponse<String> restResponse = new RestResponse<String>(ResponseType.SUCCESS, "logout.done.msg");
            response.getWriter().write(jsonConverter.getJson(restResponse).get());
            response.flushBuffer();
            /*response.resetBuffer();
            System.out.println(token.get());*/
        }
    }
}
