package com.chahilhouda.customerservice;

import com.chahilhouda.customerservice.entities.Customer;
import com.chahilhouda.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"hasnae","hasnae@mail.com"));
			customerRepository.save(new Customer(null,"karima","karima@mail.com"));
			customerRepository.save(new Customer(null,"amal","amal@mail.com"));

			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.toString());
			});
		};
	}
}