package com.example.mas.testerJednostkowy;

import com.example.mas.tester.Tester;

import java.time.LocalDate;

public class TesterJednostkowy extends Tester {
    public TesterJednostkowy(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "TesterJednostkowy{}";
    }
}
