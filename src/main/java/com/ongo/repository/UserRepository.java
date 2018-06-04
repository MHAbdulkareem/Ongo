package com.ongo.repository;

import com.ongo.model.security.OngoUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<OngoUser, String> {
    Optional<OngoUser> findByEmail(String email);
    Optional<OngoUser> deleteByEmail(String email);
}
