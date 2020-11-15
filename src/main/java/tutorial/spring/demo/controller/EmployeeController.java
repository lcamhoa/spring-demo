package tutorial.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tutorial.spring.demo.domain.Employee;
import tutorial.spring.demo.repository.EmployeeRepository;

@RestController
@AllArgsConstructor
public class EmployeeController {

	@Autowired
	private final EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
}
