package com.gadministrativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "employee_id")
    @ManyToOne
    @NotNull
    private Employee employee;

    @Column(nullable = false, updatable = false)
    @NotNull
    private LocalDate satisfiedDate;

    @Column(nullable = false, updatable = false)
    @NotNull
    private LocalDate payrollMonth;

    @Column(nullable = false, updatable = false)
    @NotNull
    private int payrollAmount;

    @JoinColumn(name = "role_id", nullable = false, updatable = false)
    @ManyToOne
    @NotNull
    private Role role;
}
