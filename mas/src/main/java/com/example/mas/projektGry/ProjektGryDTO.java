package com.example.mas.projektGry;

import com.example.mas.gra.GraDTO;
import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjektGryDTO {
    private Long id;
    private LiderZespolu liderZespolu;
    private Set<PracownikStudia> przypisaniPracownicy;
    private Long budzet;
    private double kosztMarketingu;
    private double kosztUtrzymaniaZespolu;
    private String wymaganySprzet;
    private PrzedstawicielWydawcyDTO przedstawicielWydawcy;
    private GraDTO gra;
}
