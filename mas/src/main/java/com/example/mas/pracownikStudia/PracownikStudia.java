package com.example.mas.pracownikStudia;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataZatrudnienia() {
        return dataZatrudnienia;
    }

    public void setDataZatrudnienia(LocalDate dataZatrudnienia) {
        this.dataZatrudnienia = dataZatrudnienia;
    }

    public String getAdresZamieszkania() {
        return adresZamieszkania;
    }

    public void setAdresZamieszkania(String adresZamieszkania) {
        this.adresZamieszkania = adresZamieszkania;
    }

    public boolean isAktualnyStatusZatrudnienia() {
        return aktualnyStatusZatrudnienia;
    }

    public void setAktualnyStatusZatrudnienia(boolean aktualnyStatusZatrudnienia) {
        this.aktualnyStatusZatrudnienia = aktualnyStatusZatrudnienia;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

    public void setDoswiadczenie(int doswiadczenie) {
        this.doswiadczenie = doswiadczenie;
    }

    @Override
    public String toString() {
        return "PracownikStudia{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataZatrudnienia=" + dataZatrudnienia +
                ", adresZamieszkania='" + adresZamieszkania + '\'' +
                ", aktualnyStatusZatrudnienia=" + aktualnyStatusZatrudnienia +
                ", doswiadczenie=" + doswiadczenie +
                '}';
    }
}
