package com.example.mas.przedstawicielWydawcy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class PrzedstawicielWydawcyConfig {

    @Bean
    @Order(3)
    CommandLineRunner commandLineRunnerPrzedstawicielWydawcy(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository repository) {
        return args -> {
            PrzedstawicielWydawcy przedstawicielWydawcy = new PrzedstawicielWydawcy(
                    "Benek",
                    "Kowalski",
                    "Super wydawnictow"
            );  PrzedstawicielWydawcy przedstawicielWydawcy2 = new PrzedstawicielWydawcy(
                    "Jasio",
                    "Kowalski",
                    "RITO GAMES"
            );
            repository.saveAll(List.of(przedstawicielWydawcy, przedstawicielWydawcy2));

        };
    }
}
