package com.ongo.repository;

import com.ongo.model.security.OngoRole;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<OngoRole, Long> {
}
