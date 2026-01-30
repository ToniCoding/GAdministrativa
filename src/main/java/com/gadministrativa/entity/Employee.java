package com.gadministrativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    @NotNull
    private String name;

    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    @NotNull
    private String surname;

    @CreatedDate
    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    @NotNull
    private LocalDateTime joinDate;

    @Column(columnDefinition = "TIMESTAMP DEFAULT NULL")
    private LocalDateTime endDate;

    @ManyToOne(optional = false) // Must have always a value, never NOT NULL.
    @JoinColumn(name = "department_id")
    private Department departmentId;
}
