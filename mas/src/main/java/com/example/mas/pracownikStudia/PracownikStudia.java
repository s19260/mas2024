package com.example.mas.pracownikStudia;

import com.example.mas.projektGry.ProjektGry;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PracownikStudia {

    @Id
    @SequenceGenerator(
            name = "pracownikstudia_sequence",
            sequenceName = "pracownikstudia_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pracownikstudia_sequence"
    )
    private Long id;
    private String imie;
    private String nazwisko;
    private LocalDate dataZatrudnienia;
    private String adresZamieszkania;
    private boolean aktualnyStatusZatrudnienia;
    private int doswiadczenie;
    @ManyToOne
    @JoinColumn(name = "projektGry.id")
    @JsonBackReference
    private ProjektGry projektGry;

    public PracownikStudia() {
    }

    public PracownikStudia(Long id,
                           String imie,
                           String nazwisko,
                           LocalDate dataZatrudnienia,
                           String adresZamieszkania,
                           boolean aktualnyStatusZatrudnienia,
                           int doswiadczenie) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.adresZamieszkania = adresZamieszkania;
        this.aktualnyStatusZatrudnienia = aktualnyStatusZatrudnienia;
        this.doswiadczenie = doswiadczenie;
    }

    public PracownikStudia(String imie,
                           String nazwisko,
                           LocalDate dataZatrudnienia,
                           String adresZamieszkania,
                           boolean aktualnyStatusZatrudnienia,
                           int doswiadczenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataZatrudnienia = dataZatrudnienia;
        this.adresZamieszkania = adresZamieszkania;
        this.aktualnyStatusZatrudnienia = aktualnyStatusZatrudnienia;
        this.doswiadczenie = doswiadczenie;
    }
}
