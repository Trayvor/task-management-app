package com.portfolio.taskmanagementapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE attachments SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Task task;
    @Column(nullable = false)
    private String dropboxFileId;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private LocalDateTime uploadDate;
    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean isDeleted = false;
}
