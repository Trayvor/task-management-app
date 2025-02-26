package com.portfolio.taskmanagementapp.repository;

import com.portfolio.taskmanagementapp.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
