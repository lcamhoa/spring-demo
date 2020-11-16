package tutorial.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tutorial.spring.payroll.domain.Payroll;
import tutorial.spring.payroll.repository.PayrollRepository;

@RestController
@AllArgsConstructor
public class PayrollController {

    @Autowired
    private final PayrollRepository payrollRepository;

    @GetMapping("/payrolls")
    List<Payroll> getAll() {
        return payrollRepository.findAll();
    }
}
