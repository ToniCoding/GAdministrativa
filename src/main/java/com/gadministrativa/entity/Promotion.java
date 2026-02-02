package com.gadministrativa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "promotions")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "employee_id")
    @NotNull
    @ManyToOne(optional = false)
    private Employee employee;

    @Column(nullable = false)
    @NotNull
    private LocalDate promotionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "previous_charge_id")
    private Role previousCharge;

    @ManyToOne(optional = false)
    @JoinColumn(name = "next_charge_id")
    private Role nextCharge;

    @Column(columnDefinition = "BOOL", nullable = false)
    @NotNull
    private boolean activePromotion = false;
}
