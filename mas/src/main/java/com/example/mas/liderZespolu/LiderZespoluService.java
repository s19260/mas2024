package com.example.mas.liderZespolu;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LiderZespoluService {

    private final com.example.mas.liderZespolu.LiderZespoluRepository liderZespoluRepository;

    @Autowired
    public LiderZespoluService(com.example.mas.liderZespolu.LiderZespoluRepository liderZespoluRepository) {
        this.liderZespoluRepository = liderZespoluRepository;
    }

    public List<com.example.mas.liderZespolu.LiderZespolu> getLiderZespolu() {
        return liderZespoluRepository.findAll();
    }

    public void addNewLiderZespolu(com.example.mas.liderZespolu.LiderZespolu liderZespolu) {
        System.out.println(liderZespolu);
        liderZespoluRepository.save(liderZespolu);
    }

    public void deleteLiderZespolu(Long liderZespoluId) {
        boolean exists = liderZespoluRepository.existsById(liderZespoluId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + liderZespoluId + " nie istnieje");
        }
        liderZespoluRepository.deleteById(liderZespoluId);
    }

    @Transactional
    public void updateLiderZespolu(Long liderZespoluId,
                                   String imie) {
        com.example.mas.liderZespolu.LiderZespolu liderZespolu = liderZespoluRepository.findById(liderZespoluId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + liderZespoluId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, liderZespolu.getImie())) {
            liderZespolu.setImie(imie);
        }
    }
}
