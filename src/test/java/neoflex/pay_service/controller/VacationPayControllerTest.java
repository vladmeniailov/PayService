package neoflex.pay_service.controller;

import neoflex.pay_service.service.vacation.VacationPayService;
import neoflex.pay_service.dto.vacation.VacationInfoDto;
import neoflex.pay_service.validator.VacationValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VacationPayControllerTest {

    @InjectMocks
    private VacationPayController vacationPayController;
    @Mock
    private VacationValidator vacationValidator;
    @Mock
    private VacationPayService vacationPayService;
    private VacationInfoDto mockVacationInfoDto;

    @BeforeEach
    public void setUp() {
        mockVacationInfoDto = new VacationInfoDto();
        mockVacationInfoDto.setAverageSalaryPerYear(BigDecimal.valueOf(55000));
        mockVacationInfoDto.setVacationDays(28);
    }

    @Test
    void successGetVacationPay() {
        vacationPayController.getVacationPay(mockVacationInfoDto);
        verify(vacationPayService, times(1)).calculateVacationPay(mockVacationInfoDto);
    }
}