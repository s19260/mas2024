package com.example.mas.przedstawicielWydawcy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrzedstawicielWydawcyDTO {
    private Long id;
    private String imie;
    private String nazwisko;
    private String wydawnictwo;
}
