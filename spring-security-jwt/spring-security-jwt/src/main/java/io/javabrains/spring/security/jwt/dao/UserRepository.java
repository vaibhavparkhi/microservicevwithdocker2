package io.javabrains.spring.security.jwt.dao;

import io.javabrains.spring.security.jwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
}
