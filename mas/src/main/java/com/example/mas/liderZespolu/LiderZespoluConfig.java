package com.example.mas.liderZespolu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LiderZespoluConfig {

    @Bean
    @Order(1)
    CommandLineRunner commandLineRunnerLiderZespolu(com.example.mas.liderZespolu.LiderZespoluRepository repository) {
        return args -> {
            LiderZespolu justyna = new LiderZespolu(
                    "Justyna",
                    "Matysiak",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12,
                    List.of("java", "test123")
            );


            repository.saveAll(
                    List.of(justyna)
            );
        };
    }

}
