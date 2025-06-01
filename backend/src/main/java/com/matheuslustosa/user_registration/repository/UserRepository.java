package com.matheuslustosa.user_registration.repository;

import com.matheuslustosa.user_registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>findByUsername(String username);
    Optional<User>findByEmail(String email);
}
