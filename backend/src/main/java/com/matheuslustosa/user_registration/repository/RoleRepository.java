package com.matheuslustosa.user_registration.repository;

import com.matheuslustosa.user_registration.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
