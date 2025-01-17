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
//            Set<PracownikStudia> przypisaniPracownicy = new HashSet<>();
//            przypisaniPracownicy.addAll(pracownikStudiaRepository.findAll());
            ProjektGry crash = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    12L,
                    3,
                    2,
                    "Xbox"
//                    przypisaniPracownicy
            );

            ProjektGry lol = new ProjektGry(
                    liderZespoluRepository.findLiderZespoluById(1L).get(),
                    40L,
                    10,
                    27689,
                    "PC"
            );

            PracownikStudia pracownikStudia = pracownikStudiaRepository.findPracownikStudiaById(2L).get();
            PracownikStudia pracownikStudiaLol = pracownikStudiaRepository.findPracownikStudiaById(1L).get();
            crash.addPracownikStudia(pracownikStudia);
            pracownikStudia.setProjektGry(crash);
            pracownikStudiaLol.setProjektGry(lol);
            lol.addPracownikStudia(pracownikStudiaLol);

            PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(2L).get();

            lol.setPrzedstawicielWydawcy(przedstawicielWydawcy);
            przedstawicielWydawcy.addProjektGry(lol);

            Gra gra = graRepository.findById(1L).get();
            crash.setGra(gra);
            repository.saveAll(
                    List.of(crash, lol)
            );
            pracownikStudiaRepository.save(pracownikStudia);
            pracownikStudiaRepository.save(pracownikStudiaLol);
            przedstawicielWydawcyRepository.save(przedstawicielWydawcy);
        };
    }
}
