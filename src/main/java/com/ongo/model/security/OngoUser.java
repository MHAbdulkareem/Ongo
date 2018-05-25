package com.ongo.model.security;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class OngoUser {

    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String salt;
    @Enumerated(EnumType.STRING)
    private OngoUserStatus status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<OngoRole> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public OngoUserStatus getStatus() {
        return status;
    }

    public void setStatus(OngoUserStatus status) {
        this.status = status;
    }

    public Set<OngoRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<OngoRole> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OngoUser ongoUser = (OngoUser) o;
        return Objects.equals(username, ongoUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "OngoUser{" +
                "username='" + username + '\'' +
                '}';
    }
}
