package com.ongo.service.gmaps;

import com.google.maps.GeoApiContext;
import com.ongo.config.GoogleMapsApiKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

@Slf4j
@Scope(value = "singleton")
@Service
public class GoogleMapService implements MapService {

    @Autowired
    private GoogleMapsApiKey googleMapsApiKey;

    public GoogleMapService(GoogleMapsApiKey googleMapsApiKey) {
        this.googleMapsApiKey = googleMapsApiKey;
    }

    @Override
    public GeoApiContext authenticate() {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(googleMapsApiKey.getApi_key())
                .build();
        return context;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
