package com.gadministrativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotNull
    private Employee employee;

    @Column
    @NotNull
    @CreatedDate
    private LocalDate workDay;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @NotNull
    private Instant startTime;

    @Column(columnDefinition = "DATETIME")
    private Instant leaveTime;

    @Column(nullable = false)
    private int workHours = 0;
}
