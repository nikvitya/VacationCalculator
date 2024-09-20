package ru.neoflex.neostudy.vacationcalculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.neoflex.neostudy.vacationcalculator.service.VacationPayService;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(controllers = VacationPayController.class)
class VacationPayControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    VacationPayService vacationPayService;

    @Test
    void givenAverageSalaryAndVacationDays_thenReturnOk() throws Exception {
        mvc.perform(get("/calculate")
                        .param("averageSalary", "50000.00")
                        .param("vacationDays", "28"))
                .andExpect(status().isOk());
    }

    @Test
    void givenAverageSalaryAndVacationList_thenReturnOk() throws Exception {
        mvc.perform(get("/calculate")
                        .param("averageSalary", "50000.00")
                        .param("vacationDays", "28")
                        .param("exactVacationDates", "2024-01-01", "2024-01-02"))
                .andExpect(status().isOk());
    }

    @Test
    void givenValidAverageSalaryAndNoVacationDays_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/calculate")
                        .param("averageSalary", "50000.00"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Необходимо указать кол-во отпускных дней"));
    }

    @Test
    void givenNoAverageSalaryAndVacationDays_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/calculate")
                        .param("vacationDays", "28"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Необходимо указать среднюю зарплату"));
    }

    @Test
    void givenNegativeAverageSalary_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/calculate")
                        .param("averageSalary", "-50000.00")
                        .param("vacationDays", "28"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Средняя зарплата недолжна быть отрицательной"));
    }

    @Test
    void givenNegativeVacationDays_thenReturnBadRequest() throws Exception {
        mvc.perform(get("/calculate")
                        .param("averageSalary", "50000.00")
                        .param("vacationDays", "-28"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description")
                        .value("Кол-во отпускных дней не может быть отрицательным"));
    }






}



