package neoflex.pay_service.service.vacation;

import lombok.RequiredArgsConstructor;
import neoflex.pay_service.dto.vacation.VacationInfoDto;
import neoflex.pay_service.service.AbstractPayService;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class VacationPayService extends AbstractPayService<BigDecimal> {
    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;
    private static final double NDFL_PERCENT = 0.13;

    public BigDecimal calculateVacationPay(VacationInfoDto vacationInfoDto) {
        return calculatePay(() -> {
            BigDecimal avgSalaryPerYear = vacationInfoDto.getAverageSalaryPerYear();
            BigDecimal averageEarningsPerDay = avgSalaryPerYear.divide(BigDecimal.valueOf(AVERAGE_DAYS_IN_MONTH), 2, RoundingMode.HALF_EVEN);
            BigDecimal totalPayWithoutNDFL = averageEarningsPerDay.multiply(BigDecimal.valueOf(vacationInfoDto.getVacationDays()));
            BigDecimal amountNDFL =
                    totalPayWithoutNDFL.multiply(BigDecimal.valueOf(NDFL_PERCENT)).setScale(0, RoundingMode.HALF_UP);

            return totalPayWithoutNDFL.subtract(amountNDFL); //Итоговая выплата
        });
    }

}
