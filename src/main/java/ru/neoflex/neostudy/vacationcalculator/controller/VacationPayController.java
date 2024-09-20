package ru.neoflex.neostudy.vacationcalculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.neostudy.vacationcalculator.dto.VacationResponseDto;
import ru.neoflex.neostudy.vacationcalculator.service.VacationPayService;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
public class VacationPayController {

    private final VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public VacationResponseDto calculateVacationPay
            (@RequestParam(required = false)
             @NotNull(message = "Необходимо указать среднюю зарплату")
             @PositiveOrZero(message = "Средняя зарплата недолжна быть отрицательной")
             BigDecimal averageSalary,

             @RequestParam(required = false)
             @PositiveOrZero(message = "Кол-во отпускных дней не может быть отрицательным")
             @NotNull(message = "Необходимо указать кол-во отпускных дней")
             Integer vacationDays,

             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
             List<LocalDate> exactVacationDates
            ) {
        return vacationPayService.calculateVacationPay(averageSalary, vacationDays, exactVacationDates);
    }
}
