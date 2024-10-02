package com.todoapp.ToDo.Application.repository;

import com.todoapp.ToDo.Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);

    // Find a user by their email
    Optional<User> findByEmail(String email);

    // Check if a username exists (for validation purposes)
    boolean existsByUsername(String username);

    // Check if an email exists (for validation purposes)
    boolean existsByEmail(String email);
}
