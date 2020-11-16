package tutorial.spring.payroll.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {
    @Id
    @GeneratedValue
    private
    Long id;
    private Integer employeeId;
    private Integer payAmount;
}
