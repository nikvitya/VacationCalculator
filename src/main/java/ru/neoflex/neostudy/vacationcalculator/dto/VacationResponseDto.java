package ru.neoflex.neostudy.vacationcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class VacationResponseDto {
    private String outputMessage;

    @DecimalMin(value = "0.00", inclusive = true)
    private BigDecimal vacationPay;
}