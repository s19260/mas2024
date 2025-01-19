package com.example.mas.tester;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterDTO {
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;
    private LocalDate dataZatrudnienia;
    private String adresZamieszkania;
}