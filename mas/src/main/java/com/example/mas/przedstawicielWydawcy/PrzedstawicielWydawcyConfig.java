package com.example.mas.przedstawicielWydawcy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

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
            );  PrzedstawicielWydawcy przedstawicielWydawcy2 = new PrzedstawicielWydawcy(
                    "Benek",
                    "Kowalski",
                    "Super wydawnictow ujujhu"
            );
            repository.saveAll(List.of(przedstawicielWydawcy, przedstawicielWydawcy2));

        };
    }
}
