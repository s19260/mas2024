package com.example.mas.tester;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterDTO {
    private Long id;
    private String imie;
    private String nazwisko;
}