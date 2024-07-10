package com.taxi.mapping.config;

import com.taxi.framework.mapping.service.MappingService;
import com.taxi.mapping.service.NeshanMappingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @Primary
    public MappingService mappingService(RestTemplate restTemplate) {
        NeshanMappingService neshanMappingService = new NeshanMappingService(restTemplate);
        // API Key should be provided here by the user
        neshanMappingService.setApiKey("your-api-key");
        return neshanMappingService;
    }
}
