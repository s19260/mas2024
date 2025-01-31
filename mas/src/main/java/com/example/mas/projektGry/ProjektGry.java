package com.example.mas.projektGry;

import com.example.mas.gra.Gra;
import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.pracownikStudia.PracownikStudia;

import java.util.HashSet;
import java.util.Set;

import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Table
@AllArgsConstructor
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
    @JoinColumn(name = "liderZespolu.id")
    private LiderZespolu liderZespolu;
    @OneToMany(mappedBy = "projektGry")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<PracownikStudia> przypisaniPracownicy = new HashSet<>();
    private Long budzet;
    private double kosztMarketingu;
    private double kosztUtrzymaniaZespolu;
    private String wymaganySprzet;
    @ManyToOne
    @JoinColumn(name = "przedstawicielWydawcy.id")
    @JsonBackReference
    private PrzedstawicielWydawcy przedstawicielWydawcy;
    @OneToOne
    @JoinColumn(name = "gra.id")
    private Gra gra;

    public ProjektGry(LiderZespolu liderZespolu, Long budzet, double kosztMarketingu, double kosztUtrzymaniaZespolu, String wymaganySprzet) {
        this.liderZespolu = liderZespolu;
        this.budzet = budzet;
        this.kosztMarketingu = kosztMarketingu;
        this.kosztUtrzymaniaZespolu = kosztUtrzymaniaZespolu;
        this.wymaganySprzet = wymaganySprzet;
    }

    public ProjektGry(LiderZespolu liderZespolu, Long budzet, double kosztMarketingu, double kosztUtrzymaniaZespolu, String wymaganySprzet, Set<PracownikStudia> przypisaniPracownicy) {
        this.liderZespolu = liderZespolu;
        this.budzet = budzet;
        this.kosztMarketingu = kosztMarketingu;
        this.kosztUtrzymaniaZespolu = kosztUtrzymaniaZespolu;
        this.wymaganySprzet = wymaganySprzet;
        this.przypisaniPracownicy = przypisaniPracownicy;
    }

    public void addPracownikStudia(PracownikStudia pracownikStudia){
       przypisaniPracownicy.add(pracownikStudia);
       pracownikStudia.setProjektGry(this);
    }

    public void removePracownikStudia(PracownikStudia pracownikStudia){
        przypisaniPracownicy.remove(pracownikStudia);
        pracownikStudia.setProjektGry(null);
    }

    public void removeLiderZespolu(LiderZespolu id){
        liderZespolu = null;
    }

}
