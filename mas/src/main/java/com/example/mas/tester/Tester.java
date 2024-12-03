package com.example.mas.tester;

import com.example.mas.pracownikStudia.PracownikStudia;

import java.time.LocalDate;

public class Tester extends PracownikStudia{
    public Tester(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "Tester{}";
    }
}
