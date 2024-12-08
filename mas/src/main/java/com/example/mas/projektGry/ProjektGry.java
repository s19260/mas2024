package com.example.mas.projektGry;

import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.pracownikStudia.PracownikStudia;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table
public class ProjektGry {

    @Id
    @SequenceGenerator(
            name = "projektgry_sequence",
            sequenceName = "projektgry_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "projektgry_sequence"
    )


    private Long id;
    @ManyToOne
    private LiderZespolu liderZespolu;
    @ManyToMany
    private List<PracownikStudia> przypisaniPracownicy;
    private Long budzet;
    private double kosztMarketingu;
    private double kosztUtrzymaniaZespolu;
    private String wymaganySprzet;

    public ProjektGry(Long id, LiderZespolu liderZespolu, List<PracownikStudia> przypisaniPracownicy, Long budzet, double kosztMarketingu, double kosztUtrzymaniaZespolu, String wymaganySprzet) {
        this.id = id;
        this.liderZespolu = liderZespolu;
        this.przypisaniPracownicy = przypisaniPracownicy;
        this.budzet = budzet;
        this.kosztMarketingu = kosztMarketingu;
        this.kosztUtrzymaniaZespolu = kosztUtrzymaniaZespolu;
        this.wymaganySprzet = wymaganySprzet;
    }

    public ProjektGry(LiderZespolu liderZespolu, List<PracownikStudia> przypisaniPracownicy, Long budzet, double kosztMarketingu, double kosztUtrzymaniaZespolu, String wymaganySprzet) {
        this.liderZespolu = liderZespolu;
        this.przypisaniPracownicy = przypisaniPracownicy;
        this.budzet = budzet;
        this.kosztMarketingu = kosztMarketingu;
        this.kosztUtrzymaniaZespolu = kosztUtrzymaniaZespolu;
        this.wymaganySprzet = wymaganySprzet;
    }

    public ProjektGry(LiderZespolu liderZespolu) {
        this.liderZespolu = liderZespolu;
    }

    public ProjektGry() {
    }

//    public ProjektGry(Optional<PracownikStudia> pracownikStudiaById) {
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LiderZespolu getLiderZespolu() {
        return liderZespolu;
    }

    public void setLiderZespolu(LiderZespolu liderZespolu) {
        this.liderZespolu = liderZespolu;
    }

    public List<PracownikStudia> getPrzypisaniPracownicy() {
        return przypisaniPracownicy;
    }

    public void setPrzypisaniPracownicy(List<PracownikStudia> przypisaniPracownicy) {
        this.przypisaniPracownicy = przypisaniPracownicy;
    }

    public Long getBudzet() {
        return budzet;
    }

    public void setBudzet(Long budzet) {
        this.budzet = budzet;
    }

    public double getKosztMarketingu() {
        return kosztMarketingu;
    }

    public void setKosztMarketingu(double kosztMarketingu) {
        this.kosztMarketingu = kosztMarketingu;
    }

    public double getKosztUtrzymaniaZespolu() {
        return kosztUtrzymaniaZespolu;
    }

    public void setKosztUtrzymaniaZespolu(double kosztUtrzymaniaZespolu) {
        this.kosztUtrzymaniaZespolu = kosztUtrzymaniaZespolu;
    }

    public String getWymaganySprzet() {
        return wymaganySprzet;
    }

    public void setWymaganySprzet(String wymaganySprzet) {
        this.wymaganySprzet = wymaganySprzet;
    }

    @Override
    public String toString() {
        return "ProjektGry{" +
                "liderZespolu=" + liderZespolu +
                ", przypisaniPracownicy=" + przypisaniPracownicy +
                ", budzet=" + budzet +
                ", kosztMarketingu=" + kosztMarketingu +
                ", kosztUtrzymaniaZespolu=" + kosztUtrzymaniaZespolu +
                ", wymaganySprzet='" + wymaganySprzet + '\'' +
                '}';
    }
}
