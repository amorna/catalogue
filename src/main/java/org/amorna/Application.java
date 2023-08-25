package org.amorna;

import org.amorna.entities.Product;
import org.amorna.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.amorna.controller.PingController;

import java.util.UUID;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "org.amorna.controller")
//@Import({ PingController.class })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
     CommandLineRunner commandLineRunner(ProductRepository productRepository){
       return args -> {
           productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                           .name("computer")
                           .price(2540)
                   .build());
           productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                   .name("printer")
                   .price(235)
                   .build());
           productRepository.save(Product.builder().id(UUID.randomUUID().toString())
                   .name("tablette")
                   .price(870)
                   .build());



       };
     }
}