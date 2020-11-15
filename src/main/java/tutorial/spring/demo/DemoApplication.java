package tutorial.spring.demo;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public final static Properties JPA_PROPERTIES = new Properties() {{
		        //put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
		        //put("hibernate.hbm2ddl.auto", "update");
		        //put("hibernate.ddl-auto", "update");
		        put("show-sql", "true");
		    }};


	public static void main(String[] args) {
		//Code structure: Controller -> Service  -> Repository -> Domain
		// https://springframework.guru/how-to-configure-multiple-data-sources-in-a-spring-boot-application/
		SpringApplication.run(DemoApplication.class, args);
	}

}
