package com.example.mas.testerIntegracyjny;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterIntegracyjnyDTO {
    private Long id;
    private String imie;
    private String nazwisko;
}