package com.ongo.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class GoogleMapsApiKey {

    private String api_key;

    public GoogleMapsApiKey(String api_key) {
        this.api_key = api_key;
    }

    public GoogleMapsApiKey() {
    }


}
