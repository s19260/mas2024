package com.example.mas.testerEndToEnd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TesterEndToEndConfig {

    @Bean
    CommandLineRunner commandLineRunnerTesterEndToEnd(com.example.mas.testerEndToEnd.TesterEndToEndRepository repository) {
        return args -> {
            TesterEndToEnd janusz = new TesterEndToEnd(
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
