/**
 * 
 */
package com.quapt.myf4h.product.persistence.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author logesh
 *
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "razorpay.config")
public class RazorpayConfig {

    private String keyId;

    private String keySecret;

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKeySecret() {
        return keySecret;
    }

    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

}
