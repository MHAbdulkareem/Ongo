package com.ongo.service;

import com.ongo.model.security.OngoUser;

import javax.persistence.EntityExistsException;
import java.util.Optional;

public interface UserService {

    public OngoUser add(OngoUser user) throws EntityExistsException;
    public String delete(String email);
    public String edit(OngoUser user);
    public Optional<OngoUser> find(String email);
    public Iterable<OngoUser> findAll();
}
