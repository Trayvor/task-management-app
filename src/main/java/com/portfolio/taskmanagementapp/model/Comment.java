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
@SQLDelete(sql = "UPDATE comments SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Task task;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private LocalDateTime timestamp;
    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean isDeleted = false;
}
