package com.portfolio.taskmanagementapp.model;

import com.portfolio.taskmanagementapp.model.type.TaskPriority;
import com.portfolio.taskmanagementapp.model.type.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tasks SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    private LocalDate dueDate;
    @ManyToOne
    private User assignee;
    @ManyToOne
    private Project project;
    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean isDeleted = false;
}
