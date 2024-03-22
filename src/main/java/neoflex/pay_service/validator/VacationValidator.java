package neoflex.pay_service.validator;

import lombok.extern.slf4j.Slf4j;
import neoflex.pay_service.exception.DataValidationException;
import neoflex.pay_service.dto.vacation.VacationInfoDto;
import org.springframework.stereotype.Component;


import java.math.BigDecimal;

@Slf4j
@Component
public class VacationValidator {

    public void validateVacation(VacationInfoDto vacationInfoDto) {
        validateSalary(vacationInfoDto);
        validateDays(vacationInfoDto);
    }

    private void validateSalary(VacationInfoDto vacationInfoDto) {
        BigDecimal averageSalaryPerYear = vacationInfoDto.getAverageSalaryPerYear();
        if (averageSalaryPerYear == null || averageSalaryPerYear.compareTo(BigDecimal.valueOf(0)) <= 0) {
            log.error("The salary provided is incorrect: {}", averageSalaryPerYear);
            throw new DataValidationException("The salary incorrect, try again.");
        }
    }

    private void validateDays(VacationInfoDto vacationInfoDto) {
        Integer vacationDays = vacationInfoDto.getVacationDays();
        if (vacationDays == null || vacationDays <= 0 || vacationDays > 100) {
            log.error("The number of days is incorrect: {}", vacationDays);
            throw new DataValidationException("The number of days is incorrect, try again.");
        }
    }

}
