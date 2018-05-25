package com.ongo.model.security;

import javax.persistence.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OngoRole ongoRole = (OngoRole) o;
        return Objects.equals(id, ongoRole.id) &&
                roles == ongoRole.roles &&
                Objects.equals(user, ongoRole.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roles, user);
    }

    @Override
    public String toString() {
        return "OngoRole{" +
                "id=" + id +
                ", roles=" + roles +
                ", user=" + user +
                '}';
    }
}
