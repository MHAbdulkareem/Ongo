package com.ongo.controller.json;


import lombok.Data;

import java.util.LinkedHashMap;

@Data
public class LoginResponse {
    private ResponseStatus status;
    private LinkedHashMap<String, String> data = new LinkedHashMap<>();

    public LoginResponse() {
    }

    public LoginResponse(ResponseStatus status) {
        this.status = status;
    }

    public LoginResponse addData(String key, String value) {
        this.getData().put(key, value);
        return this;
    }

}
