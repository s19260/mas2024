package com.example.mas.testerIntegracyjny;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TesterIntegracyjnyConfig {

    @Bean
    CommandLineRunner commandLineRunnerTesterIntegracyjny(com.example.mas.testerIntegracyjny.TesterIntegracyjnyRepository repository) {
        return args -> {
            TesterIntegracyjny janusz = new TesterIntegracyjny(
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
