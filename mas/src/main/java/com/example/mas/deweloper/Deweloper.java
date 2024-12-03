package com.example.mas.deweloper;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Deweloper extends PracownikStudia {

    private String jezykiProgramowania;

    public Deweloper(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie, String jezykiProgramowania) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
        this.jezykiProgramowania = jezykiProgramowania;
    }

    public Deweloper() {
    }

    public String getJezykiProgramowania() {
        return jezykiProgramowania;
    }

    public void setJezykiProgramowania(String jezykiProgramowania) {
        this.jezykiProgramowania = jezykiProgramowania;
    }

    @Override
    public String toString() {
        return "Deweloper{" +
                "jezykiProgramowania='" + jezykiProgramowania + '\'' +
                '}';
    }
}
