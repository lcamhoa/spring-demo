package tutorial.spring.payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tutorial.spring.payroll.domain.Payroll;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
	
}
