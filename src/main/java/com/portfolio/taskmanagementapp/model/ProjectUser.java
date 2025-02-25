package com.portfolio.taskmanagementapp.model;

import com.portfolio.taskmanagementapp.model.type.ProjectUserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@NoArgsConstructor
@SQLDelete(sql = "UPDATE projects_users SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
@Table(name = "projects_users")
public class ProjectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Project user;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectUserRole role;
    @Column(nullable = false, columnDefinition = "tinyint")
    private boolean isDeleted = false;
}
