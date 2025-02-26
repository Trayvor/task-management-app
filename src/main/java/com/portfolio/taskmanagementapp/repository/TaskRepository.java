package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
