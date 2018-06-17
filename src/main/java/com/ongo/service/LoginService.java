package com.ongo.service;

import com.ongo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void doLogin() {
    }
}
