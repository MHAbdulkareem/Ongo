package com.ongo.model.user;

import com.ongo.model.security.OngoUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Data
@EqualsAndHashCode(exclude = {"user"})
@Entity
public class OngoUserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    @Lob
    private byte[] avatar;
    private LocalDate dob;
    @OneToOne
    private OngoUser user;

    public OngoUserProfile() {
    }

    public OngoUserProfile(String firstname, String lastname, String email, OngoUser user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.user = user;
    }
}
