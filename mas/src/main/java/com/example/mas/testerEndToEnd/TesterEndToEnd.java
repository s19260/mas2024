package com.example.mas.testerEndToEnd;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class TesterEndToEnd extends PracownikStudia {

    public TesterEndToEnd(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public TesterEndToEnd() {

    }

    @Override
    public String toString() {
        return "TesterEndToEnd{}";
    }
}
