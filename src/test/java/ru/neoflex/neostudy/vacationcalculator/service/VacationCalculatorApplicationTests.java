package ru.neoflex.neostudy.vacationcalculator.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.neoflex.neostudy.vacationcalculator.util.Constants.AVERAGE_NUMBER_OF_DAYS_IN_MONTH;

@SpringBootTest
@RequiredArgsConstructor
class VacationCalculatorApplicationTests {
    private static final int testVacationDays = 28;
    private static BigDecimal testAverageSalary = new BigDecimal("50000.00");
    private static BigDecimal testAverageDailySalary;
    @Autowired
    private VacationPayService vacationPayService;

    @BeforeAll
    static void setUp() {
        testAverageDailySalary = testAverageSalary.divide(BigDecimal.valueOf(AVERAGE_NUMBER_OF_DAYS_IN_MONTH), 2, RoundingMode.HALF_EVEN);
    }

    @Test
    void calculateVacationPayWhenExactVacationDatesAreNotProvided() {
        BigDecimal actualVacationPay = vacationPayService.calculateVacationPay(testAverageSalary, testVacationDays, null).getVacationPay();
        assertEquals(testAverageDailySalary.multiply(BigDecimal.valueOf(testVacationDays))
                , actualVacationPay);
    }

    @Test
    void calculateVacationPayWhenExactVacationDatesAreProvided() {

        List<LocalDate> vacationDates = List.of(
                LocalDate.of(2024, 01, 01),
                LocalDate.of(2024, 01, 02),
                LocalDate.of(2024, 01, 21)
        );

        BigDecimal actualVacationPay = vacationPayService.calculateVacationPay(testAverageSalary, testVacationDays, vacationDates).getVacationPay();
        assertEquals(BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN), actualVacationPay);
    }
}
