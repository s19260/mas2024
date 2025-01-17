package com.example.mas.deweloper;
import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeweloperDTO {
    private Long id;
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;
    private String adresZamieszkania;
    private List<String> jezykiProgramowania;
}
