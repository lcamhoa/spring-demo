package tutorial.spring.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import tutorial.spring.demo.domain.Employee;
import tutorial.spring.demo.repository.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Find Employee By Name")
    void shouldFindEmployeeByName() {
        final String name = "Alex";
        // given
        final Employee alex = Employee.builder().name(name).role("Employee").build();
        employeeRepository.save(alex);
        entityManager.flush();

        // when
        final Employee found = employeeRepository.findByName(alex.getName()).stream().findFirst().get();

        // then
        assertAll("found", () -> {
            assertEquals(name, found.getName());
            assertEquals(1L, found.getId());
            assertEquals("Employee", found.getRole());
        });

    }

}
