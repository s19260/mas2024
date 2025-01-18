package com.example.mas.deweloper;
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
public class DeweloperDoZapisuDTO {
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;
    private LocalDate dataZatrudnienia;
}

