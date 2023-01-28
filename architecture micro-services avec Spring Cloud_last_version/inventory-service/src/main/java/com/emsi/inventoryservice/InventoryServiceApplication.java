package com.emsi.inventoryservice;

import com.emsi.inventoryservice.entities.Product;
import com.emsi.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){

		restConfiguration.exposeIdsFor(Product.class);
		return args -> {
			productRepository.save(new Product(null,"Lenovo E590",20000,12));
			productRepository.save(new Product(null,"Latitude S34",12000,3));
			productRepository.save(new Product(null,"vaio XDS",1000,23));

// log messages using log(Level level, String msg)
			Logger loging= Logger.getLogger(InventoryServiceApplication.class.getName());
			productRepository.findAll().forEach(c->
					loging.log(Level.FINE, c.toString()));






		};
	}

}
