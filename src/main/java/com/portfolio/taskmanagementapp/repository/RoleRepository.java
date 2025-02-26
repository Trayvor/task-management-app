package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Role;
import com.portfolio.taskmanagementapp.model.type.UserRole;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(UserRole role);
}
