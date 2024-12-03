package com.example.mas.przedstawicielWydawcy;

import com.example.mas.pracownikStudia.PracownikStudia;

import java.time.LocalDate;

public class PrzedstawicielWydawcy extends PracownikStudia {
    public PrzedstawicielWydawcy(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "PrzedstawicielWydawcy{}";
    }
}
