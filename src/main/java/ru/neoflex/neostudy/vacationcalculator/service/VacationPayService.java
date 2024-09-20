package ru.neoflex.neostudy.vacationcalculator.service;

import ru.neoflex.neostudy.vacationcalculator.dto.VacationResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface VacationPayService {
    VacationResponseDto calculateVacationPay(BigDecimal averageSalary, Integer vacationDays, List<LocalDate> exactVacationDates);
}
