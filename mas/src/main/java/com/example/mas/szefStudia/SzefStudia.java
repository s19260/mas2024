package com.example.mas.szefStudia;

import com.example.mas.pracownikStudia.PracownikStudia;

import java.time.LocalDate;

public class SzefStudia extends PracownikStudia {
    public SzefStudia(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    @Override
    public String toString() {
        return "SzefStudia{}";
    }
}
