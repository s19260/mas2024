package com.example.mas.przedstawicielWydawcy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class PrzedstawicielWydawcyConfig {

    @Bean
    @Order(4)
    CommandLineRunner commandLineRunnerPrzedstawicielWydawcy(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository repository) {
        return args -> {
            PrzedstawicielWydawcy przedstawicielWydawcy = new PrzedstawicielWydawcy(
                    "Benek",
                    "Kowalski",
                    "Super wydawnictow"
            );
            repository.save(przedstawicielWydawcy);
        };
    }
}
