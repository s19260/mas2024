package com.example.mas.przedstawicielWydawcy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PrzedstawicielWydawcyService {

    private final com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository;

    @Autowired
    public PrzedstawicielWydawcyService(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository) {
        this.przedstawicielWydawcyRepository = przedstawicielWydawcyRepository;
    }

    public List<com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy> getPrzedstawicielWydawcy() {
        return przedstawicielWydawcyRepository.findAll();
    }

    public void addNewPrzedstawicielWydawcy(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy przedstawicielWydawcy) {
        System.out.println(przedstawicielWydawcy);
        przedstawicielWydawcyRepository.save(przedstawicielWydawcy);
    }

    public void deletePrzedstawicielWydawcy(Long przedstawicielWydawcyId) {
        boolean exists = przedstawicielWydawcyRepository.existsById(przedstawicielWydawcyId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + przedstawicielWydawcyId + " nie istnieje");
        }
        przedstawicielWydawcyRepository.deleteById(przedstawicielWydawcyId);
    }

    @Transactional
    public void updatePrzedstawicielWydawcy(Long przedstawicielWydawcyId,
                                            String imie) {
        com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(przedstawicielWydawcyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + przedstawicielWydawcyId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, przedstawicielWydawcy.getImie())) {
            przedstawicielWydawcy.setImie(imie);
        }
    }
}
