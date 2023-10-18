package com.chahil.inventoryservice;

import com.chahil.inventoryservice.entities.Product;
import com.chahil.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"Computer",123,12));
            productRepository.save(new Product(null,"Printer",345,12));
            productRepository.save(new Product(null,"Phone",987,12));

            productRepository.findAll().forEach(product -> {
                System.out.println(product.toString());
            });
        };
    }

}
