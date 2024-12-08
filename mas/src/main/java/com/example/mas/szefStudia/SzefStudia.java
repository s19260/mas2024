package com.example.mas.szefStudia;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class SzefStudia extends PracownikStudia {

    public SzefStudia(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public SzefStudia() {

    }

    @Override
    public String toString() {
        return "SzefStudia{}";
    }
}
