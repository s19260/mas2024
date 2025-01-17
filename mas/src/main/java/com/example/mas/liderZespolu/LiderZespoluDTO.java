package com.example.mas.liderZespolu;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiderZespoluDTO {
    private Long id;
    private String imie;
    private String nazwisko;
}