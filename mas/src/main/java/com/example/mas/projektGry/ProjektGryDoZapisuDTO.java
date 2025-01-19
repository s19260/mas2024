package com.example.mas.projektGry;

import com.example.mas.gra.GraDTO;
import com.example.mas.liderZespolu.LiderZespolu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjektGryDoZapisuDTO {
    private Long budzet;
    private double kosztMarketingu;
    private double kosztUtrzymaniaZespolu;
    private String wymaganySprzet;
    private GraDTO graDTO;
}
