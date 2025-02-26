package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Long> {
}
