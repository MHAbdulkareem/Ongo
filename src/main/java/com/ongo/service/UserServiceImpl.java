package com.ongo.service;

import com.ongo.model.security.OngoUser;
import com.ongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OngoUser add(OngoUser user) throws EntityExistsException {
        if(!userRepository.findByEmail(user.getEmail()).isPresent()) {
            return userRepository.save(user);
        }else {
            throw new EntityExistsException("User already exist!");
        }
    }

    @Override
    public String delete(String email) {
        userRepository.deleteByEmail(email);
        return "removed";
    }

    @Override
    public String edit(OngoUser user) {
        userRepository.save(user);
        return "saved";
    }

    @Override
    public Optional<OngoUser> find(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Iterable<OngoUser> findAll() {
        return userRepository.findAll();
    }
}
