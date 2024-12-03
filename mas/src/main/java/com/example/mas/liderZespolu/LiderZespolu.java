package com.example.mas.liderZespolu;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class LiderZespolu extends PracownikStudia {
    public LiderZespolu(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public LiderZespolu() {

    }


    @Override
    public String toString() {
        return "LiderZespolu{}";
    }

}
