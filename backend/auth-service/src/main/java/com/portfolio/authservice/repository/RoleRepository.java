package com.portfolio.authservice.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.authservice.model.Role;
import com.portfolio.authservice.model.type.UserRole;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(UserRole role);
}
