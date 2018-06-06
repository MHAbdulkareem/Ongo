package com.ongo.config;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class GoogleMapsApiKey {

    private String API_KEY;

    public GoogleMapsApiKey(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public GoogleMapsApiKey() {
    }


}
