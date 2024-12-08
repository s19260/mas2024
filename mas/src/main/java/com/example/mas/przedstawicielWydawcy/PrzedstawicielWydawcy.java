package com.example.mas.przedstawicielWydawcy;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.zlecenieProjektu.ZlecenieProjektu;
import com.example.mas.zlecenieProjektu.ZlecenieProjektuRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
public class PrzedstawicielWydawcy extends PracownikStudia {
    public PrzedstawicielWydawcy(String imie, String nazwisko, LocalDate dataZatrudnienia, String adresZamieszkania, boolean aktualnyStatusZatrudnienia, int doswiadczenie) {
        super(imie, nazwisko, dataZatrudnienia, adresZamieszkania, aktualnyStatusZatrudnienia, doswiadczenie);
    }

    public PrzedstawicielWydawcy() {

    }

//    public ZlecenieProjektu zlecProjekt(ZlecenieProjektu zlecenie){
//        System.out.println(zlecenie.toString());
//        return zlecenie;
//    }

        @Override
        public String toString () {
            return "PrzedstawicielWydawcy{}";

    }
}
