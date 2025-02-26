package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.ProjectUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectUserRepository extends JpaRepository<ProjectUser, Long> {
}
