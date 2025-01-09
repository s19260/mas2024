package com.example.mas.pracownikStudia;
import com.example.mas.projektGry.ProjektGry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PracownikStudiaDoZapisuDTO {
        private Long id;
        private String imie;
        private String nazwisko;
        private boolean aktualnyStatusZatrudnienia;
}

