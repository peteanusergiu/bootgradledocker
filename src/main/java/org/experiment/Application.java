package org.experiment;

import org.experiment.config.ExtensionConfig;
import org.experiment.config.RestConfiguration;
import org.experiment.config.ServiceConfiguration;
import org.experiment.extensions.annotation.Log;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = {
		DataSourceTransactionManagerAutoConfiguration.class,
		DataSourceAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class
})
@Import({RestConfiguration.class, ServiceConfiguration.class, ExtensionConfig.class})
public class Application {

	@Log
	Logger log;

	public static void main(String[] args) {
		new SpringApplication(Application.class).run(args);
	}

//	@Bean
//	public CommandLineRunner demo(CustomerRepository repository) {
//		return (args) -> {
//			// save a couple of customers
//			repository.save(new CustomerEntity("Jack", "Bauer"));
//			repository.save(new CustomerEntity("Chloe", "O'Brian"));
//			repository.save(new CustomerEntity("Kim", "Bauer"));
//			repository.save(new CustomerEntity("David", "Palmer"));
//			repository.save(new CustomerEntity("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (CustomerEntity customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			CustomerEntity customer = repository.findOne(1L);
//			log.info("CustomerEntity found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("CustomerEntity found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			for (CustomerEntity bauer : repository.findByLastName("Bauer")) {
//				log.info(bauer.toString());
//			}
//			log.info("");
//		};
//	}

	@Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
	public DispatcherServlet dispatcherServlet(){
		return new DispatcherServlet();
	}
	
	@Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
	public ServletRegistrationBean servletRegistrationBean(){
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*");
		registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
		return registration;
	}
}
