package com.example.mas.gra;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table
public class Gra {

    @Id
    @SequenceGenerator(
            name = "gra_sequence",
            sequenceName = "gra_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gra_sequence"
    )
    private Long id;
    private String nazwa;
    private String platformaDocelowa;
    private LocalDate dataWydania;
    private String opisGry;
    private String studioPartnerskie;

    public Gra() {
    }

    public Gra(Long id, String nazwa, String platformaDocelowa, LocalDate dataWydania, String opisGry, String studioPartnerskie) {
        this.id = id;
        this.nazwa = nazwa;
        this.platformaDocelowa = platformaDocelowa;
        this.dataWydania = dataWydania;
        this.opisGry = opisGry;
        this.studioPartnerskie = studioPartnerskie;
    }

    public Gra(String nazwa, String platformaDocelowa, LocalDate dataWydania, String opisGry, String studioPartnerskie) {
        this.nazwa = nazwa;
        this.platformaDocelowa = platformaDocelowa;
        this.dataWydania = dataWydania;
        this.opisGry = opisGry;
        this.studioPartnerskie = studioPartnerskie;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getPlatformaDocelowa() {
        return platformaDocelowa;
    }

    public void setPlatformaDocelowa(String platformaDocelowa) {
        this.platformaDocelowa = platformaDocelowa;
    }

    public LocalDate getDataWydania() {
        return dataWydania;
    }

    public void setDataWydania(LocalDate dataWydania) {
        this.dataWydania = dataWydania;
    }

    public String getOpisGry() {
        return opisGry;
    }

    public void setOpisGry(String opisGry) {
        this.opisGry = opisGry;
    }

    public String getStudioPartnerskie() {
        return studioPartnerskie;
    }

    public void setStudioPartnerskie(String studioPartnerskie) {
        this.studioPartnerskie = studioPartnerskie;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Gra{" +
                "nazwa='" + nazwa + '\'' +
                ", platformaDocelowa='" + platformaDocelowa + '\'' +
                ", dataWydania=" + dataWydania +
                ", opisGry='" + opisGry + '\'' +
                ", studioPartnerskie='" + studioPartnerskie + '\'' +
                '}';
    }
}
