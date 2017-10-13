package com.quapt.myf4h.product.persistence.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
public class RazorpayConfigurer {

    @Inject
    private RazorpayConfig config;

    @Bean
    public RazorpayClient razorpayClient() {
        System.out.println("keyId "+config.getKeyId());
        RazorpayClient client = null;
        try {
            System.out.println("keyId "+config.getKeyId());
            client = new RazorpayClient(config.getKeyId(), config.getKeySecret());
            return client;
        } catch (RazorpayException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return client;
    }

}
