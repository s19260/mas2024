package com.example.mas.gra;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class GraConfig {

    @Bean
    @Order(4)
    CommandLineRunner commandLineRunnerGra(com.example.mas.gra.GraRepository repository) {
        return args -> {
            Gra crash = new Gra(
                    "Crash Bandicoot",
                    "PS3",
                    LocalDate.of(1990, Month.MARCH, 25),
                    "Platformowka",
                    "Naughty Dog"
            );

            Gra spyro = new Gra(
                    "Spyro the dragon",
                    "PS4",
                    LocalDate.of(1990, Month.MARCH, 25),
                    "Platformowka",
                    "Naughty Dog"
            );

            Gra tekken = new Gra(
                    "Tekken 7",
                    "PS4",
                    LocalDate.of(1990, Month.MARCH, 25),
                    "Platformowka",
                    "Naughty Dog"
            );

            Gra finalFantasy  = new Gra(
                    "Final Fantasy",
                    "PS4",
                    LocalDate.of(1990, Month.MARCH, 25),
                    "Platformowka",
                    "Naughty Dog"
            );




            repository.saveAll(
                    List.of(crash, spyro, tekken, finalFantasy)
            );
        };
    }

}
