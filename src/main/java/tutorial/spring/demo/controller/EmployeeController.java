package tutorial.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tutorial.spring.demo.domain.Employee;
import tutorial.spring.demo.repository.EmployeeRepository;

@RestController
@AllArgsConstructor
@Slf4j
public class EmployeeController {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        log.debug("Get All called");
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/findByName")
    List<Employee> findByName(@RequestParam String name) {
        return employeeRepository.findByName(name);
    }
}
