package neoflex.pay_service.validator;

import neoflex.pay_service.exception.DataValidationException;
import neoflex.pay_service.dto.vacation.VacationInfoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class VacationValidatorTest {

    private VacationValidator vacationValidator;
    private VacationInfoDto mockVacationInfoDto;

    @BeforeEach
    public void setUp() {
        vacationValidator = new VacationValidator();
        mockVacationInfoDto = new VacationInfoDto();
    }

    @Test
    void shouldThrowWhenAverageSalaryIncorrect() {
        mockVacationInfoDto.setAverageSalaryPerYear(BigDecimal.valueOf(-10000));
        mockVacationInfoDto.setVacationDays(10);

        assertThrows(DataValidationException.class,() ->
                vacationValidator.validateVacation(mockVacationInfoDto));
    }

    @Test
    void shouldThrowWhenDaysIncorrect() {
        mockVacationInfoDto.setAverageSalaryPerYear(BigDecimal.valueOf(50000));
        mockVacationInfoDto.setVacationDays(-10);

        assertThrows(DataValidationException.class,() ->
                vacationValidator.validateVacation(mockVacationInfoDto));
    }
}