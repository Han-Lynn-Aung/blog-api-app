package com.natrix.blogapi.BlogApiApplication.repository;

import com.natrix.blogapi.BlogApiApplication.model.user.User;
import com.natrix.blogapi.BlogApiApplication.security.UserPrincipal;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    default User getUser(UserPrincipal currentUser) {
        return findByUsername(currentUser.getUsername()).get();
    }

    default User getUserByUsername(String username) {
        return findByUsername(username).
                orElseThrow(() -> new ResourceNotFoundException("User" , "username", username));
    }

}
