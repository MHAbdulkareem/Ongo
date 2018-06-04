package com.ongo.model.security;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Objects;

@Data
@EqualsAndHashCode(exclude = {"user"})
@Entity
public class OngoRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OngoUserRoles role;
    @ManyToOne
    private OngoUser user;

    public OngoRole() {
    }

    public OngoRole(OngoUserRoles role, OngoUser user) {
        this.role = role;
        this.user = user;
    }

}
