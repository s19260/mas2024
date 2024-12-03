package com.example.mas.testerEndToEnd;

import com.example.mas.tester.Tester;

import java.time.LocalDate;

public class TesterEndToEnd extends Tester {
    public TesterEndToEnd(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "TesterEndToEnd{}";
    }
}
