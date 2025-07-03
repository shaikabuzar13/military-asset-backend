package com.springrest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://military-asset-ui-system0402.netlify.app") // Allow your React frontend
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true); // Important: allow sending cookies/Authorization
    }
}
