package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
