package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.role.Role;
import com.natrix.blogapi.BlogApiApplication.model.role.RoleName;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role,Long> {

    Optional<Role> findByName(RoleName name);
}
