package com.ongo.controller.json;

import com.ongo.model.security.OngoUserRoles;

import javax.validation.constraints.NotEmpty;

public class UserForm {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String email;
    @NotEmpty
    private OngoUserRoles roles = OngoUserRoles.USER;

}
