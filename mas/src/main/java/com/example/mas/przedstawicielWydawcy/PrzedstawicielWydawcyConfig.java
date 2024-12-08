package com.example.mas.przedstawicielWydawcy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PrzedstawicielWydawcyConfig {

    @Bean
    CommandLineRunner commandLineRunnerPrzedstawicielWydawcy(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository repository) {
        return args -> {
            PrzedstawicielWydawcy marian = new PrzedstawicielWydawcy(
                    "Marian",
                    "Pazdzioch",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12
            );


            repository.saveAll(
                    List.of(marian)
            );
        };
    }

}
