package com.ongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Profile;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class OngoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OngoApplication.class, args);
    }
}
