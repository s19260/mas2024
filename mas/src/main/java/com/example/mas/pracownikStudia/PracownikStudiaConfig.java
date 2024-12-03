package com.example.mas.pracownikStudia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PracownikStudiaConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(PracownikStudiaRepository repository) {
//        return args -> {
//            PracownikStudia marcin = new PracownikStudia(
//                    "Marcin",
//                    "Kowalski",
//                    LocalDate.of(2024, Month.NOVEMBER, 5),
//                    "Dolna 52, Warszawa",
//                    true,
//                    12
//            );
//
//            PracownikStudia adam = new PracownikStudia(
//                    "Adam",
//                    "Wisniewski",
//                    LocalDate.of(2023, Month.MARCH, 12),
//                    "Jana Kazimierza 12, Warszawa",
//                    true,
//                    7
//            );
//
//            repository.saveAll(
//                    List.of(marcin, adam)
//            );
//        };
//    }
}
