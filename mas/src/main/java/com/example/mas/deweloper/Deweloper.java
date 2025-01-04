package com.example.mas.deweloper;

import com.example.mas.pracownikStudia.PracownikStudia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Deweloper extends PracownikStudia {

    private List<String> jezykiProgramowania;

    public Deweloper(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie, List<String> jezykiProgramowania) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
        this.jezykiProgramowania = jezykiProgramowania;
    }

    public Deweloper() {
    }

    @Override
    public String toString() {
        return "Deweloper{" +
                "jezykiProgramowania='" + jezykiProgramowania + '\'' +
                '}';
    }
}
