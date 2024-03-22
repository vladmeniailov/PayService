package neoflex.pay_service.controller;

import lombok.RequiredArgsConstructor;
import neoflex.pay_service.service.vacation.VacationPayService;
import neoflex.pay_service.dto.vacation.VacationInfoDto;
import neoflex.pay_service.validator.VacationValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class VacationPayController {

    private final VacationValidator vacationValidator;
    private final VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public BigDecimal getVacationPay(@RequestBody VacationInfoDto vacationInfoDto) {
        vacationValidator.validateVacation(vacationInfoDto);
        return vacationPayService.calculateVacationPay(vacationInfoDto);
    }

}
