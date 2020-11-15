package tutorial.spring.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import tutorial.spring.demo.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findAll(Sort sort);
	Page<Employee> findAll(Pageable pageable);
	List<Employee> findByName(String name);
}
