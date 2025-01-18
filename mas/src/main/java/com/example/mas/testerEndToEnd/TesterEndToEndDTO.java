package com.example.mas.testerEndToEnd;

import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TesterEndToEndDTO {
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;
    private LocalDate dataZatrudnienia;
}