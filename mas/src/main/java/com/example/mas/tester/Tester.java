package com.example.mas.tester;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Tester extends PracownikStudia {

    public Tester(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public Tester() {

    }

    @Override
    public String toString() {
        return "Tester{}";
    }
}
