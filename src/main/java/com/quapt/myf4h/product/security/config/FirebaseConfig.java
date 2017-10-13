package com.quapt.myf4h.product.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@ConfigurationProperties(prefix = "firebase.config")
public class FirebaseConfig {

    private String serviceAccountKey;

    private String databaseUrl;

    public String getServiceAccountKey() {
        Assert.hasText(serviceAccountKey);
        return serviceAccountKey;
    }

    public void setServiceAccountKey(String serviceAccountKey) {
        this.serviceAccountKey = serviceAccountKey;
    }

    public String getDatabaseUrl() {
        Assert.hasText(databaseUrl);
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

}
