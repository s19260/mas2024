package com.example.mas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.example.mas.zlecenieProjektu")
public class MasApplication {
    public static void main(String[] args) {
       SpringApplication.run(MasApplication.class, args);

    }
}


//       PrzedstawicielWydawcy p1 = new PrzedstawicielWydawcy("dsads","sdasd", LocalDate.of(2024, Month.NOVEMBER, 5),"Dolna 52, Warszawa",true,12);
//
//       ZlecenieProjektu pro = new ZlecenieProjektu(LocalDate.of(2012, Month.NOVEMBER, 5),
//               "bijatyka",
//               "Xbox",
//               12000,
//               5,
//               "rozpoczety");
//
//       p1.zlecProjekt(pro);
