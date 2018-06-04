package com.ongo.controller;

import com.ongo.controller.json.LoginResponse;
import com.ongo.repository.UserRepository;
import com.ongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class LoginController {

    private UserService userService;

    public LoginController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse loginService(@RequestParam(value = "username") String username,
                                      @RequestParam(value = "password") String password) {

        return null;
    }

}
