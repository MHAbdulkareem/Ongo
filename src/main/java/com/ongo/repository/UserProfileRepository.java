package com.ongo.repository;

import com.ongo.model.user.OngoUserProfile;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository extends CrudRepository<OngoUserProfile, Long> {
}
