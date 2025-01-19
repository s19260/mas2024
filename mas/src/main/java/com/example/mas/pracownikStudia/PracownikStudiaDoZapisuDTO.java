package com.example.mas.pracownikStudia;
import com.example.mas.gra.GraDTO;
import com.example.mas.projektGry.ProjektGry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracownikStudiaDoZapisuDTO {
        private String imie;
        private String nazwisko;
        private boolean aktualnyStatusZatrudnienia;
        private LocalDate dataZatrudnienia;
        private GraDTO graDTO;
}

