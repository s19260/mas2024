package com.example.mas.projektGry;

import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Configuration
public class ProjektGryConfig {

    @Bean
    @DependsOn("commandLineRunnerLiderZespolu")
    CommandLineRunner commandLineRunnerProjektGry(com.example.mas.projektGry.ProjektGryRepository repository, LiderZespoluRepository liderZespoluRepository, PracownikStudiaRepository pracownikStudiaRepository) {
        return args -> {
            ProjektGry crash = new ProjektGry(
                liderZespoluRepository.findLiderZespoluById(1L).get(),
                List.of(pracownikStudiaRepository.findPracownikStudiaById(2L).get()),
                    12L,
                    1,
                    2,
                    "dupa"
                    );

            repository.saveAll(
                    List.of(crash)
            );
        };
    }
}
