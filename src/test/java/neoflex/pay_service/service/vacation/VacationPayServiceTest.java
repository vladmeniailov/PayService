package neoflex.pay_service.service.vacation;

import neoflex.pay_service.dto.vacation.VacationInfoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.springframework.test.util.AssertionErrors.assertEquals;

class VacationPayServiceTest {
    private VacationPayService vacationPayService;
    private VacationInfoDto mockVacationInfoDto;


    @BeforeEach
    public void setUp() {
        vacationPayService = new VacationPayService();
        mockVacationInfoDto = new VacationInfoDto();
    }

    @Test
    public void successVacationPayCalculated() {
        mockVacationInfoDto.setAverageSalaryPerYear(BigDecimal.valueOf(60000));
        mockVacationInfoDto.setVacationDays(10);

        BigDecimal expected = BigDecimal.valueOf(17815.80).setScale(2);
        BigDecimal actual = vacationPayService.calculateVacationPay(mockVacationInfoDto);

        assertEquals("Верный расчёт отпускных", expected, actual);
    }
}