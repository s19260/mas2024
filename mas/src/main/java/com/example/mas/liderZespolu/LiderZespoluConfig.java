package com.example.mas.liderZespolu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LiderZespoluConfig {

    @Bean
    CommandLineRunner commandLineRunnerLiderZespolu(com.example.mas.liderZespolu.LiderZespoluRepository repository) {
        return args -> {
            LiderZespolu justyna = new LiderZespolu(
                    "Justyna",
                    "Matysiak",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12
            );


            repository.saveAll(
                    List.of(justyna)
            );
        };
    }

}
