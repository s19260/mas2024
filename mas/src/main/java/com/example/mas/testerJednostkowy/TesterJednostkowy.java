package com.example.mas.testerJednostkowy;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class TesterJednostkowy extends PracownikStudia {

    public TesterJednostkowy(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public TesterJednostkowy() {

    }

    @Override
    public String toString() {
        return "TesterJednostkowy{}";
    }
}
