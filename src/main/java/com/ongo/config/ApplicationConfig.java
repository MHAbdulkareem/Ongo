package com.ongo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.yml")
})
public class ApplicationConfig {

    @Value("${google.maps.API_KEY}")
    private String API_KEY;

    @Bean
    public GoogleMapsApiKey googleMapsApiKey() {
        GoogleMapsApiKey mapsApiKey = new GoogleMapsApiKey(API_KEY);
        return mapsApiKey;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

}
