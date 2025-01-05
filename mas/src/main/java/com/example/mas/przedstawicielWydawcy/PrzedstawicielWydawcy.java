package com.example.mas.przedstawicielWydawcy;

import com.example.mas.projektGry.ProjektGry;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrzedstawicielWydawcy {
    @Id
    @SequenceGenerator(
            name = "przedstawicielwydawcy_sequence",
            sequenceName = "przedstawicielwydawcy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "przedstawicielwydawcy_sequence"
    )
    private Long id;
    private String imie;
    private String nazwisko;
    private String wydawnictwo;
    @OneToMany(mappedBy = "przedstawicielWydawcy")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Set<ProjektGry> projektyGier = new HashSet<>();

    public PrzedstawicielWydawcy(String imie, String nazwisko, String wydawnictwo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wydawnictwo = wydawnictwo;
    }

    public void addProjektGry(ProjektGry projekt) {
        projektyGier.add(projekt);
        projekt.setPrzedstawicielWydawcy(this);
    }

    public void removeProjektGry(ProjektGry projekt) {
        projektyGier.remove(projekt);
        projekt.setPrzedstawicielWydawcy(null);
    }

}
