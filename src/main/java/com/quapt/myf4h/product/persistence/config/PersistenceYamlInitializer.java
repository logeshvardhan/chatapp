package com.quapt.myf4h.product.persistence.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class PersistenceYamlInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext applicationContext) {
        Resource resource = applicationContext.getResource("classpath:persistence_config.yml");

        YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
        try {
            applicationContext.getEnvironment().getPropertySources()
                    .addFirst(loader.load("persistence_config", resource, null));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
