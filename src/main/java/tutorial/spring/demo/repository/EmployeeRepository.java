package tutorial.spring.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tutorial.spring.demo.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    List<Employee> findAll(Sort sort);

    @Override
    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE name LIKE %:name%")
    List<Employee> findByName(@Param("name") String name);
}
