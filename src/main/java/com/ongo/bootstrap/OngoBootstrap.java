package com.ongo.bootstrap;

import com.ongo.model.security.OngoRole;
import com.ongo.model.security.OngoUser;
import com.ongo.model.security.OngoUserRoles;
import com.ongo.model.security.OngoUserStatus;
import com.ongo.model.user.OngoUserProfile;
import com.ongo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class OngoBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;

    public OngoBootstrap(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Loading Users.....");
        userRepository.saveAll(getUsers());
        log.info("Loading Users.....Complete");
    }

    public Set<OngoUser> getUsers() {
        Set<OngoUser> users = new HashSet<>();

        OngoUser user1 = new OngoUser("mhmairago", new BCryptPasswordEncoder().encode("P4muh,d5"), OngoUserStatus.UNVERIFIED);
        user1.addRole(new OngoRole(OngoUserRoles.USER, user1));
        user1.addRole(new OngoRole(OngoUserRoles.ADMINISTRATOR, user1));
        user1.setProfile(new OngoUserProfile("Muhammad", "Hussaini", "mhmairago@gmail.com", user1));

        OngoUser user2 = new OngoUser("mhussaini", new BCryptPasswordEncoder().encode("Password"), OngoUserStatus.ACTIVE);
        user2.addRole(new OngoRole(OngoUserRoles.USER, user2));
        user2.setProfile(new OngoUserProfile("Ahmed", "Musa", "mhuss2@gmail.com", user2));

        users.add(user1);
        users.add(user2);

        return users;
    }
}
