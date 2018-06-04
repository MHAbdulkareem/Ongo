package com.ongo.controller;

import com.ongo.controller.json.RegistrationResponse;
import com.ongo.controller.json.ResponseStatus;
import com.ongo.model.security.OngoRole;
import com.ongo.model.security.OngoUser;
import com.ongo.model.security.OngoUserRoles;
import com.ongo.model.security.OngoUserStatus;
import com.ongo.model.user.OngoUserProfile;
import com.ongo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public RegistrationResponse addUser(@RequestParam(value = "username") String username,
                                        @RequestParam(value = "password") String password,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "firstname") String firstname,
                                        @RequestParam(value = "lastname") String lastname) {

        OngoUser user = new OngoUser(username, new BCryptPasswordEncoder().encode(password), OngoUserStatus.UNVERIFIED);
        user.addRole(new OngoRole(OngoUserRoles.USER, user));
        OngoUserProfile profile = new OngoUserProfile(firstname, lastname, email, user);
        user.addProfile(profile);

        userService.add(user);

        return new RegistrationResponse(ResponseStatus.SUCCESS);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity errorHandler(Exception exc) {
        RegistrationResponse res = new RegistrationResponse(ResponseStatus.ERROR);
        res.addData("status", "02");
        res.addData("message", exc.getMessage());

        log.error(exc.getMessage(), exc);
        return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
    }

}
