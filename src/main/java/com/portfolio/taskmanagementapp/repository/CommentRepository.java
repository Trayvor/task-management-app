package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
