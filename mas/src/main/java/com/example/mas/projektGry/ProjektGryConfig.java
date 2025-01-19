package com.example.mas.projektGry;

import com.example.mas.gra.Gra;
import com.example.mas.gra.GraRepository;
import com.example.mas.liderZespolu.LiderZespoluRepository;
import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import jakarta.transaction.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@Transactional
public class ProjektGryConfig {

    @Bean
    @Order(5)
    CommandLineRunner commandLineRunnerProjektGry(com.example.mas.projektGry.ProjektGryRepository repository,
                                                  LiderZespoluRepository liderZespoluRepository,
                                                  PracownikStudiaRepository pracownikStudiaRepository,
                                                  PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository,
                                                  GraRepository graRepository) {
        return args -> {
            ProjektGry crash = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    12000L,
                    3000,
                    2000,
                    "Xbox"
            );

            ProjektGry lol = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(2L).get(),
                    40000L,
                    10000,
                    15000,
                    "PC, PS4"
            );

            ProjektGry lol2 = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    80000L,
                    20000,
                    1600,
                    "PC, XBOX, PS5"
            );

            PracownikStudia pracownikStudia1 = pracownikStudiaRepository.findPracownikStudiaById(4L).get();
           PracownikStudia pracownikStudia2 = pracownikStudiaRepository.findPracownikStudiaById(2L).get();
            PracownikStudia pracownikStudia3 = pracownikStudiaRepository.findPracownikStudiaById(3L).get();
            PracownikStudia pracownikStudia4 = pracownikStudiaRepository.findPracownikStudiaById(1L).get();
            lol.addPracownikStudia(pracownikStudia4);
            lol.addPracownikStudia(pracownikStudia1);
            lol2.addPracownikStudia(pracownikStudia2);
            crash.addPracownikStudia(pracownikStudia3);
            pracownikStudia4.setProjektGry(lol);
           pracownikStudia2.setProjektGry(lol2);
            pracownikStudia3.setProjektGry(crash);

            PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(2L).get();

            crash.setPrzedstawicielWydawcy(przedstawicielWydawcy);
            lol.setPrzedstawicielWydawcy(przedstawicielWydawcy);
            lol2.setPrzedstawicielWydawcy(przedstawicielWydawcy);
            przedstawicielWydawcy.addProjektGry(lol);
            przedstawicielWydawcy.addProjektGry(lol2);
            przedstawicielWydawcy.addProjektGry(crash);

            Gra gra = graRepository.findById(1L).get();
            crash.setGra(gra);
            repository.saveAll(
                    List.of(crash, lol, lol2)
            );
            pracownikStudiaRepository.save(pracownikStudia1);
            pracownikStudiaRepository.save(pracownikStudia2);
            pracownikStudiaRepository.save(pracownikStudia3);
            pracownikStudiaRepository.save(pracownikStudia4);
            przedstawicielWydawcyRepository.save(przedstawicielWydawcy);
        };
    }
}
