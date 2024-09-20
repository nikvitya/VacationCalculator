package ru.neoflex.neostudy.vacationcalculator.util;

import ru.neoflex.neostudy.vacationcalculator.model.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HolidayAndWeekend {
    public final static int CURRENT_YEAR = LocalDate.ofYearDay(2024, 1).getYear();
    private static final List<Holiday> holidays = Arrays.asList(
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 1), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 2), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 3), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 4), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 5), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 6), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 7), "Рождество Христово"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 1, 8), "Новый Год"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 2, 23), "День защитника Отечества"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 3, 8), "Международный женский день"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 5, 1), "Праздник Весны и Труда"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 5, 9), "День Победы"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 6, 12), " День России"),
            new Holiday(LocalDate.of(CURRENT_YEAR, 11, 4), "День народного единства")
    );

    public static boolean isNotHolidayOrWeekend(LocalDate date) {
        return !date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                && !date.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                && holidays.stream().noneMatch(holiday -> holiday.getHolidayDate().equals(date));
    }


}
