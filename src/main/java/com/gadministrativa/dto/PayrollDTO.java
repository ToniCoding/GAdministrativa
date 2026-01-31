package com.gadministrativa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayrollDTO {
    private int id;
    private int employeeId;
    private LocalDateTime satisfiedDate;
    private LocalDate payrollMonth;
    private int payrollAmount;
    private int role_id;
}
