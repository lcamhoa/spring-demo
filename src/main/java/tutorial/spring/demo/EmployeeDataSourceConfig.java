package tutorial.spring.demo;

import static tutorial.spring.demo.DemoApplication.JPA_PROPERTIES;

import javax.persistence.EntityManagerFactory;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties("app.datasource.employee")
@EnableJpaRepositories(basePackages = "tutorial.spring.demo.repository",
        entityManagerFactoryRef = EmployeeDataSourceConfig.EMPLOYEE_ENTITY_MANAGER_FACTORY,
        transactionManagerRef = EmployeeDataSourceConfig.EMPLOYEE_TRANSACTION_MANAGER)
public class EmployeeDataSourceConfig extends HikariConfig {

    public static final String MODEL_PACKAGE = "tutorial.spring.demo.domain";

    public static final String EMPLOYEE_ENTITY_MANAGER_FACTORY = "employeeEntityManagerFactory";

    // Transaction manager for each datasource
    public static final String EMPLOYEE_TRANSACTION_MANAGER = "employeeTransactionManager";
    static final String EMPLOYEE_DS = "employeeDataSouce";

    @Bean(name = EMPLOYEE_DS)
    public HikariDataSource employeeDataSource() {
        return new HikariDataSource(this);
    }

    @Bean(name = EMPLOYEE_ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(
            @Qualifier(EMPLOYEE_DS) final HikariDataSource dataSource) {
        return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName("Employee");
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
    }

    @Bean(name = EMPLOYEE_TRANSACTION_MANAGER)
    public PlatformTransactionManager memberTransactionManager(
            @Qualifier(EMPLOYEE_ENTITY_MANAGER_FACTORY) final
                    EntityManagerFactory employeeEntityManagerFactory) {
        return new JpaTransactionManager(employeeEntityManagerFactory);
    }

}
