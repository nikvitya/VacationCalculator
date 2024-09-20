package ru.neoflex.neostudy.vacationcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Holiday {
    private LocalDate holidayDate;
    private String holidayName;
}
