package com.example.mas.testerIntegracyjny;

import com.example.mas.tester.Tester;

import java.time.LocalDate;

public class TesterIntegracyjny extends Tester {
    public TesterIntegracyjny(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "TesterIntegracyjny{}";
    }
}
