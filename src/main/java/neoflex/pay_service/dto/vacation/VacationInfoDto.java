package neoflex.pay_service.dto.vacation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacationInfoDto {
    private BigDecimal averageSalaryPerYear;
    private Integer vacationDays;
}
