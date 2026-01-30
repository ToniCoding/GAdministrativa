package com.gadministrativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRole {
    @JoinColumn(name = "employee_id")
    @NotNull
    private Employee employee;

    @JoinColumn(name = "role_id")
    @NotNull
    private Role role;
}
