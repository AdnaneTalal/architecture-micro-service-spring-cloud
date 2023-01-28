package com.emsi.customerservice;

import com.emsi.customerservice.entities.Customer;
import com.emsi.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class CustomerServiceApplication {

	private Logger loging;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){

		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"adnane","adnane@gmail.com"));
			customerRepository.save(new Customer(null,"talal","talal@gmail.com"));
			customerRepository.save(new Customer(null,"john","john@gmail.com"));

// log messages using log(Level level, String msg)
			loging= Logger.getLogger(CustomerServiceApplication.class.getName());
			customerRepository.findAll().forEach(c->
					loging.log(Level.INFO, c.toString()));






		};
	}
}
