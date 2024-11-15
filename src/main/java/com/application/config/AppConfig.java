package com.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class AppConfig {
    @Bean
    public ResourceLoader resourceLoader(){
        return new DefaultResourceLoader();
    }
}
