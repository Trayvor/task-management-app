package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
