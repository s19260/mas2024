package com.example.mas.projektGry;

import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.projektGry.ProjektGry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ProjektGryConfig {

    @Bean
    CommandLineRunner commandLineRunnerProjektGry(com.example.mas.projektGry.ProjektGryRepository repository, LiderZespoluRepository liderZespoluRepository, LiderZespoluRepository liderZespoluRepository) {
        return args -> {
            ProjektGry crash = new ProjektGry(



                    );


            repository.saveAll(
                    List.of(crash)
            );
        };
    }
}
