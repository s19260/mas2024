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

//            Deweloper jasio = new Deweloper(
//                    1L,
//                    "Jasio",
//                    "Kowalski",
//                    LocalDate.of(2024, Month.NOVEMBER, 5),
//                    "Dolna 52, Warszawa",
//                    true,
//                    12,
//                    List.of("java", "c#"),
//                    projektGryRepository.getReferenceById(0L)
//            );

            Deweloper adam = new Deweloper(
                    "Adam",
                    "Wisniewski",
                    LocalDate.of(2023, Month.MARCH, 12),
                    "Jana Kazimierza 12, Warszawa",
                    true,
                    7,
                    List.of("c++", "c")
            );

            repository.saveAll(
                    List.of(marcin, adam)
            );
        };
    }

}
