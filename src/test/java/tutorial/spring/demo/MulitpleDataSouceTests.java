package tutorial.spring.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootTest
@Tag(DemoApplicationTests.TAG_INTEGRATION_TEST)
public class MulitpleDataSouceTests {

    @Autowired
    @Qualifier(EmployeeDataSourceConfig.EMPLOYEE_DS)
    private HikariDataSource employeeDataSource;

    @Autowired
    @Qualifier(PayrollDataSourceConfig.PAYROLL_DS)
    private HikariDataSource payrollDataSource;

    @Test
    @DisplayName("Initiaize 2 DataSources")
    void shouldMulitpleDataSources() {
        assertNotNull(employeeDataSource, "Employee DS should exits");
        assertNotNull(payrollDataSource, "Payroll DS should exits");
    }

}
