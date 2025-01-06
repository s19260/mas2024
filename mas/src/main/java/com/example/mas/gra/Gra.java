package com.example.mas.gra;

import com.example.mas.projektGry.ProjektGry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @OneToOne(mappedBy = "gra")
    private ProjektGry projektGry;

    public Gra(String nazwa, String platformaDocelowa, LocalDate dataWydania, String opisGry, String studioPartnerskie) {
        this.nazwa = nazwa;
        this.platformaDocelowa = platformaDocelowa;
        this.dataWydania = dataWydania;
        this.opisGry = opisGry;
        this.studioPartnerskie = studioPartnerskie;
    }
}
