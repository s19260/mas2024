package com.example.mas.testerJednostkowy;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TesterJednostkowyConfig {

    @Bean
    CommandLineRunner commandLineRunnerTesterJednostkowy(com.example.mas.testerJednostkowy.TesterJednostkowyRepository repository) {
        return args -> {
            TesterJednostkowy janusz = new TesterJednostkowy(
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
