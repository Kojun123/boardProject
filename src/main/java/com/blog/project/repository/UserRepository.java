package com.blog.project.repository;

import com.blog.project.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByuserName(String userName);

    boolean existsByEmail(String email);

    boolean existsByUserName(String name);
}
