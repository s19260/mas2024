package com.example.mas.testerIntegracyjny;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class TesterIntegracyjny extends PracownikStudia {

    public TesterIntegracyjny(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public TesterIntegracyjny() {

    }

    @Override
    public String toString() {
        return "TesterIntegracyjny{}";
    }
}
