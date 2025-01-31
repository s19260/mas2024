package com.example.mas.deweloper;

import com.example.mas.projektGry.ProjektGryRepository;
import com.example.mas.projektGry.ProjektGryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class DeweloperConfig {

    @Bean
    @Order(2)
    CommandLineRunner commandLineRunnerD(com.example.mas.deweloper.DeweloperRepository repository, ProjektGryService projektGryService, ProjektGryRepository projektGryRepository) {
        return args -> {
            Deweloper marcin = new Deweloper(
                    "Marcin",
                    "Kowalski",
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "Dolna 52, Warszawa",
                    true,
                    12,
                    List.of("java", "c#")
            );

            Deweloper adam = new Deweloper(
                    "Adam",
                    "Wisniewski",
                    LocalDate.of(2023, Month.MARCH, 12),
                    "Jana Kazimierza 12, Warszawa",
                    true,
                    7,
                    List.of("c++", "c")
            );

            Deweloper krzys = new Deweloper(
                    "Krzysztof",
                    "Adamski",
                    LocalDate.of(2023, Month.APRIL, 22),
                    "Jana Kazimierza 12, Warszawa",
                    true,
                    3,
                    List.of("c++", "c")
            );

            Deweloper ania = new Deweloper(
                    "Anna",
                    "Kowalska",
                    LocalDate.of(2023, Month.APRIL, 22),
                    "Jana Kazimierza 12, Warszawa",
                    true,
                    3,
                    List.of("c++", "c")
            );

            repository.saveAll(
                    List.of(marcin, adam, krzys, ania)
            );
        };
    }

}
