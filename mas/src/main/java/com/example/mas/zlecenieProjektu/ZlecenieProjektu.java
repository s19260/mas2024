package com.example.mas.zlecenieProjektu;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ZlecenieProjektu {
    @Id
    @SequenceGenerator(
            name = "zlecenieprojektu_sequence",
            sequenceName = "zlecenieprojektu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "zlecenieprojektu_sequence"
    )
    private Long id;
    private LocalDate planowanaDataZakonczeniaZlecenia;
    private String rodzajGry;
    private String platformaDocelowa;
    private double planowanyBudzet;
    private int przewidywanaIloscPracownikow;
    private String status;

    public ZlecenieProjektu(LocalDate planowanaDataZakonczeniaZlecenia, String rodzajGry, String platformaDocelowa, double planowanyBudzet, int przewidywanaIloscPracownikow, String status) {
        this.planowanaDataZakonczeniaZlecenia = planowanaDataZakonczeniaZlecenia;
        this.rodzajGry = rodzajGry;
        this.platformaDocelowa = platformaDocelowa;
        this.planowanyBudzet = planowanyBudzet;
        this.przewidywanaIloscPracownikow = przewidywanaIloscPracownikow;
        this.status = status;
    }

    public ZlecenieProjektu() {

    }

    public LocalDate getPlanowanaDataZakonczeniaZlecenia() {
        return planowanaDataZakonczeniaZlecenia;
    }

    public void setPlanowanaDataZakonczeniaZlecenia(LocalDate planowanaDataZakonczeniaZlecenia) {
        this.planowanaDataZakonczeniaZlecenia = planowanaDataZakonczeniaZlecenia;
    }

    public String getRodzajGry() {
        return rodzajGry;
    }

    public void setRodzajGry(String rodzajGry) {
        this.rodzajGry = rodzajGry;
    }

    public String getPlatformaDocelowa() {
        return platformaDocelowa;
    }

    public void setPlatformaDocelowa(String platformaDocelowa) {
        this.platformaDocelowa = platformaDocelowa;
    }

    public double getPlanowanyBudzet() {
        return planowanyBudzet;
    }

    public void setPlanowanyBudzet(double planowanyBudzet) {
        this.planowanyBudzet = planowanyBudzet;
    }

    public int getPrzewidywanaIloscPracownikow() {
        return przewidywanaIloscPracownikow;
    }

    public void setPrzewidywanaIloscPracownikow(int przewidywanaIloscPracownikow) {
        this.przewidywanaIloscPracownikow = przewidywanaIloscPracownikow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ZlecenieProjektu{" +
                "planowanaDataZakonczeniaZlecenia=" + planowanaDataZakonczeniaZlecenia +
                ", rodzajGry='" + rodzajGry + '\'' +
                ", platformaDocelowa='" + platformaDocelowa + '\'' +
                ", planowanyBudzet=" + planowanyBudzet +
                ", przewidywanaIloscPracownikow=" + przewidywanaIloscPracownikow +
                ", status='" + status + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
