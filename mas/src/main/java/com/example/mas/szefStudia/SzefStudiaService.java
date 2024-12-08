package com.example.mas.szefStudia;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SzefStudiaService {

    private final com.example.mas.szefStudia.SzefStudiaRepository szefStudiaRepository;

    @Autowired
    public SzefStudiaService(com.example.mas.szefStudia.SzefStudiaRepository szefStudiaRepository) {
        this.szefStudiaRepository = szefStudiaRepository;
    }

    public List<com.example.mas.szefStudia.SzefStudia> getSzefStudia() {
        return szefStudiaRepository.findAll();
    }

    public void addNewSzefStudia(com.example.mas.szefStudia.SzefStudia szefStudia) {
        System.out.println(szefStudia);
        szefStudiaRepository.save(szefStudia);
    }

    public void deleteSzefStudia(Long szefStudiaId) {
        boolean exists = szefStudiaRepository.existsById(szefStudiaId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + szefStudiaId + " nie istnieje");
        }
        szefStudiaRepository.deleteById(szefStudiaId);
    }

    @Transactional
    public void updateSzefStudia(Long szefStudiaId,
                                 String imie) {
        com.example.mas.szefStudia.SzefStudia szefStudia = szefStudiaRepository.findById(szefStudiaId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + szefStudiaId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, szefStudia.getImie())) {
            szefStudia.setImie(imie);
        }
    }
}
