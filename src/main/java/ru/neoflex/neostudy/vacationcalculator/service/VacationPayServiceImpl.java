package ru.neoflex.neostudy.vacationcalculator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.neostudy.vacationcalculator.dto.VacationResponseDto;
import ru.neoflex.neostudy.vacationcalculator.util.HolidayAndWeekend;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static ru.neoflex.neostudy.vacationcalculator.util.Constants.AVERAGE_NUMBER_OF_DAYS_IN_MONTH;
import static ru.neoflex.neostudy.vacationcalculator.util.Constants.dtoResponseMessage;

@Service
@Slf4j
public class VacationPayServiceImpl implements VacationPayService {

    @Override
    public VacationResponseDto calculateVacationPay(
            BigDecimal averageSalary,
            Integer vacationDays,
            List<LocalDate> exactVacationDates
    ) {
        BigDecimal averageDailySalary = averageSalary.divide(BigDecimal.valueOf(AVERAGE_NUMBER_OF_DAYS_IN_MONTH), 2, RoundingMode.HALF_EVEN);

        if (exactVacationDates == null || exactVacationDates.isEmpty()) {
            return calculateVacationPayWhenExactVacationDatesAreNotProvided(averageDailySalary, vacationDays);
        }

        return calculateVacationPayWhenExactVacationDatesAreProvided(averageDailySalary, exactVacationDates);
    }

    private VacationResponseDto calculateVacationPayWhenExactVacationDatesAreNotProvided(
            BigDecimal averageDailySalary, Integer vacationDays
    ) {
        BigDecimal vacationPay = averageDailySalary.multiply(BigDecimal.valueOf(vacationDays));
        return new VacationResponseDto(dtoResponseMessage, vacationPay);
    }

    private VacationResponseDto calculateVacationPayWhenExactVacationDatesAreProvided(
            BigDecimal averageDailySalary, List<LocalDate> exactVacationDates
    ) {
        List<LocalDate> vacationDaysWithoutHolidaysAndWeekend = exactVacationDates
                .stream()
                .distinct()
                .filter(localDate -> HolidayAndWeekend.isNotHolidayOrWeekend(localDate))
                .collect(Collectors.toList());

        Integer numberOfVacationDaysWithoutHolidaysAndWeekend = vacationDaysWithoutHolidaysAndWeekend.size();

        BigDecimal vacationPay = averageDailySalary
                .multiply(BigDecimal.valueOf(numberOfVacationDaysWithoutHolidaysAndWeekend));

        return new VacationResponseDto(dtoResponseMessage, vacationPay);
    }

}
