package com.ongo.model.security;

import javax.persistence.*;

public class OngoRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OngoUserRoles roles;
    @ManyToOne
    private OngoUser user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OngoUserRoles getRoles() {
        return roles;
    }

    public void setRoles(OngoUserRoles roles) {
        this.roles = roles;
    }

    public OngoUser getUser() {
        return user;
    }

    public void setUser(OngoUser user) {
        this.user = user;
    }
}
