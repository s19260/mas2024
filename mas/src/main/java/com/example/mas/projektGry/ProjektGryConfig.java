package com.example.mas.projektGry;

import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.List;
import java.util.Set;

@Configuration
public class ProjektGryConfig {

    @Bean
    @Order(3)
    CommandLineRunner commandLineRunnerProjektGry(com.example.mas.projektGry.ProjektGryRepository repository, LiderZespoluRepository liderZespoluRepository, PracownikStudiaRepository pracownikStudiaRepository) {
        return args -> {
            ProjektGry crash = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    12L,
                    1,
                    2,
                    "Xbox"
            );

            PracownikStudia pracownikStudia = pracownikStudiaRepository.findPracownikStudiaById(2L).get();
            crash.addPracownikStudia(pracownikStudia);
            pracownikStudia.setProjektGry(crash);
            repository.saveAll(
                    List.of(crash)
            );
            pracownikStudiaRepository.save(pracownikStudia);
        };
    }
}
