package com.example.mas.zlecenieProjektu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class ZlecenieProjektuConfig {

    @Bean
    CommandLineRunner commandLineRunnerZlecenieProjektu(com.example.mas.zlecenieProjektu.ZlecenieProjektuRepository repository) {
        return args -> {
            ZlecenieProjektu zlecenie1 = new ZlecenieProjektu(
                    LocalDate.of(2024, Month.NOVEMBER, 5),
                    "platformowa",
                    "Xbox",
                    12000,
                    5,
                    "rozpoczety"
            );


            repository.saveAll(
                    List.of(zlecenie1)
            );
        };
    }
}
