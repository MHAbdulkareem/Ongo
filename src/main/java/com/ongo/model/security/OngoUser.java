package com.ongo.model.security;

import com.ongo.model.user.OngoUserProfile;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"profile", "roles"})
@Entity
public class OngoUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private OngoUserStatus status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<OngoRole> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private OngoUserProfile profile;

    public OngoUser() {
    }

    public OngoUser(String email, String password, OngoUserStatus status) {
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public OngoUser addRole(OngoRole role) {
        role.setUser(this);
        this.getRoles().add(role);
        return this;
    }

    public OngoUser addProfile(OngoUserProfile profile) {
        profile.setUser(this);
        this.profile = profile;
        return this;
    }

}
