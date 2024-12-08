package com.example.mas.projektGry;

import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
public class ProjektGryConfig {

    @Bean
    @Order(3)
    CommandLineRunner commandLineRunnerProjektGry(com.example.mas.projektGry.ProjektGryRepository repository, LiderZespoluRepository liderZespoluRepository, PracownikStudiaRepository pracownikStudiaRepository) {
        return args -> {
            ProjektGry crash = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    List.of(pracownikStudiaRepository.findPracownikStudiaById(2L).get(),pracownikStudiaRepository.findPracownikStudiaById(3L).get()),
                    12L,
                    1,
                    2,
                    "xbox"
            );

            ProjektGry crash2 = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    List.of(pracownikStudiaRepository.findPracownikStudiaById(2L).get(),pracownikStudiaRepository.findPracownikStudiaById(3L).get()),
                    12L,
                    1,
                    2,
                    "dupa"
            );


            repository.saveAll(
                    List.of(crash, crash2)
            );
        };
    }
}
