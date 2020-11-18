package tutorial.spring.demo.unittest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import tutorial.spring.demo.DemoApplicationTests;
import tutorial.spring.demo.controller.EmployeeController;
import tutorial.spring.demo.domain.Employee;
import tutorial.spring.demo.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
@Tag(DemoApplicationTests.TAG_UNIT_TEST)
public class EmployeeControllerTest {

    @Mock
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeController controler;

    @BeforeEach
    void setUp() {
        controler = new EmployeeController(employeeRepository);
    }

    @Test
    @DisplayName("Verify /employees endpoint")
    void shouldMulitpleDataSources() {
        final List<Employee> employess = Arrays.asList(Employee.builder().name("John").build() );
        when(employeeRepository.findAll()).thenReturn(employess);
        List<Employee> actual = controler.getAll();
        assertAll("employee", () -> assertEquals("John", actual.get(0).getName()));
    }

}
