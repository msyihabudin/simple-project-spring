package com.syhb.cleancode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = {"com.syhb.cleancode.repositories"})
//@EntityScan(value = {"com.syhb.cleancode.dao"})
@SpringBootApplication
// (scanBasePackages = "com.syhb.cleancode")
//@ComponentScan(basePackageClasses = ItemInventoryController.class)
public class SimpleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProjectApplication.class, args);
	}

}
