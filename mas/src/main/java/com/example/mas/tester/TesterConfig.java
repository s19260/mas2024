package com.example.mas.tester;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TesterConfig {

    @Bean
    CommandLineRunner commandLineRunnerTester(com.example.mas.tester.TesterRepository repository) {
        return args -> {
            Tester bartosz = new Tester(
                    "Bartosz",
                    "Iksinski",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12
            );


            repository.saveAll(
                    List.of(bartosz)
            );
        };
    }

}
