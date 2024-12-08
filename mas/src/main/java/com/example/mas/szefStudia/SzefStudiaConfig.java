package com.example.mas.szefStudia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class SzefStudiaConfig {

    @Bean
    CommandLineRunner commandLineRunnerSzefStudia(com.example.mas.szefStudia.SzefStudiaRepository repository) {
        return args -> {
            SzefStudia janusz = new SzefStudia(
                    "Janusz",
                    "Iksinski",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12
            );


            repository.saveAll(
                    List.of(janusz)
            );
        };
    }

}
