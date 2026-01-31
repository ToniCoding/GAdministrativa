package com.gadministrativa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDTO {
    private int id;
    private int employeeId;
    private LocalDate workDay;
    private Instant startTime;
    private Instant endTime;
    private int workHours;
}
