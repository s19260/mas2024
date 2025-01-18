package com.example.mas.testerJednostkowy;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterJednostkowyDTO {
    private Long id;
    private String imie;
    private String nazwisko;
}