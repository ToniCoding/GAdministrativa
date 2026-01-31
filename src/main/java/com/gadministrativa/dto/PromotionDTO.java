package com.gadministrativa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDTO {
    private int id;
    private int employeeId;
    private LocalDate promotionDate;
    private int previousChargeId;
    private int nextChargeId;
    private boolean activePromotion;
}
