package com.example.mas.liderZespolu;

import com.example.mas.deweloper.Deweloper;
import jakarta.persistence.Entity;


import java.time.LocalDate;
import java.util.List;

@Entity
public class LiderZespolu extends Deweloper {
    public LiderZespolu(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie, List<String> jezykiProgramowania) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie, jezykiProgramowania);
    }

    public LiderZespolu() {

    }


    @Override
    public String toString() {
        return "LiderZespolu{}";
    }

}
