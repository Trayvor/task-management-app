package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
