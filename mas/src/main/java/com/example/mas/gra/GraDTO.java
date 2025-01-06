package com.example.mas.gra;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraDTO {
    private Long id;
    private String nazwa;
    private String platformaDocelowa;
    private LocalDate dataWydania;
    private String opisGry;
    private String studioPartnerskie;
}
