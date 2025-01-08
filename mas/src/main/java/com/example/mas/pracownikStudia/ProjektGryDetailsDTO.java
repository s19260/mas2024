package com.example.mas.pracownikStudia;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjektGryDetailsDTO {

    private Long id;
    private Long budzet;
    private double kosztMarketingu;
    private double kosztUtrzymaniaZespolu;
    private String wymaganySprzet;
}
