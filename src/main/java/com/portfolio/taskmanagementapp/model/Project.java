package com.portfolio.taskmanagementapp.model;

import com.portfolio.taskmanagementapp.model.type.ProjectStatus;
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
@SQLDelete(sql = "UPDATE projects SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;
    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean isDeleted = false;
}
