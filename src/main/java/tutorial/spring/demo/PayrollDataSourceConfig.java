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
@ConfigurationProperties("app.datasource.payroll")
@EnableJpaRepositories(
		basePackages = {"tutorial.spring.payroll.repository"},
		entityManagerFactoryRef = PayrollDataSourceConfig.PAYROLL_ENTITY_MANAGER_FACTORY,
		transactionManagerRef = PayrollDataSourceConfig.PAYROLL_TRANSACTION_MANAGER
)
public class PayrollDataSourceConfig extends HikariConfig {
	
    public static final String MODEL_PACKAGE = "tutorial.spring.payroll.domain";
    static final String PAYROLL_DS = "payrollDS";
    @Bean(name=PAYROLL_DS)
    public HikariDataSource pallrollDataSource() {
        return new HikariDataSource(this);
    }
        
    public static final String PAYROLL_ENTITY_MANAGER_FACTORY = "payrollEntityManagerFactory";
    @Bean(name = PAYROLL_ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean payrollEntityManagerFactory(@Qualifier(PAYROLL_DS) final HikariDataSource dataSource) {
    	return new LocalContainerEntityManagerFactoryBean() {{
            setDataSource(dataSource);
            setPersistenceProviderClass(HibernatePersistenceProvider.class);
            setPersistenceUnitName("Payroll");
            setPackagesToScan(MODEL_PACKAGE);
            setJpaProperties(JPA_PROPERTIES);
        }};
   }
    
    // Transaction manager for datasource
    public static final String PAYROLL_TRANSACTION_MANAGER = "payrollTransationManager";
    @Bean(name=PAYROLL_TRANSACTION_MANAGER)
    public PlatformTransactionManager payrollTransactionManager(
            final @Qualifier(PAYROLL_ENTITY_MANAGER_FACTORY) EntityManagerFactory payrollEntityManagerFactory) {
        return new JpaTransactionManager(payrollEntityManagerFactory);
    }
    
    
}
