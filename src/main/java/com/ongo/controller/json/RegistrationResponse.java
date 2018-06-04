package com.ongo.controller.json;

import lombok.Data;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

@Data
public class RegistrationResponse {

    private ResponseStatus status;
    private LinkedHashMap<String, String> data = new LinkedHashMap<>();

    public RegistrationResponse() {
    }

    public RegistrationResponse(ResponseStatus status) {
        this.status = status;
    }

    public RegistrationResponse addData(String key, String value) {
        this.getData().put(key, value);
        return this;
    }

}
