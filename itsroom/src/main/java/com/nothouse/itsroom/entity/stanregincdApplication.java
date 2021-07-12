package com.nothouse.itsroom.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class stanregincdApplication {

  private static final Logger log = LoggerFactory.getLogger(stanregincdApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(stanregincdApplication.class);
  }

  @Bean
  public CommandLineRunner demo(stanregincdRepository repository) {
    return (args) -> {
      // save a few customers
      // repository.save(new stanregincd("Jack", "Bauer"));
      // repository.save(new stanregincd("Chloe", "O'Brian"));
      // repository.save(new stanregincd("Kim", "Bauer"));
      // repository.save(new stanregincd("David", "Palmer"));
      // repository.save(new stanregincd("Michelle", "Dessler"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      for (stanregincd stanregincd : repository.findAll()) {
        log.info(stanregincd.toString());
      }
      log.info("");

      // fetch an individual customer by ID
      stanregincd customer = repository.findByRegion_cd("1000000000");
      log.info("Customer found with findById(1000000000):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findBySido_cd("1100000000").forEach(bauer -> {
        log.info(bauer.toString());
      });
      // for (Customer bauer : repository.findByLastName("Bauer")) {
      //  log.info(bauer.toString());
      // }
      log.info("");
    };
  }

}