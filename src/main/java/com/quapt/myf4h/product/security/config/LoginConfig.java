package com.quapt.myf4h.product.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@ConfigurationProperties(prefix = "login.config")
public class LoginConfig {

    private String tokenParameter;

    private String userIdParameter;

    private String passwordParameter;

    public String getTokenParameter() {
        Assert.hasText(tokenParameter, "Token parameter not configured.");
        return tokenParameter;
    }

    public void setTokenParameter(String tokenParameter) {
        this.tokenParameter = tokenParameter;
    }

    public String getUserIdParameter() {
        Assert.hasText(userIdParameter, "userId parameter not configured.");
        return userIdParameter;
    }

    public void setUserIdParameter(String userIdParameter) {
        this.userIdParameter = userIdParameter;
    }

    public String getPasswordParameter() {
        Assert.hasText(passwordParameter, "password parameter not configured.");
        return passwordParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }
}
