package com.quapt.myf4h.product.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth.config")
public class AuthorizationConfig {

    private boolean csrfCheckEnabled;

    public boolean isCsrfCheckEnabled() {
        return csrfCheckEnabled;
    }

    public void setCsrfCheckEnabled(boolean csrfCheckEnabled) {
        this.csrfCheckEnabled = csrfCheckEnabled;
    }

}
