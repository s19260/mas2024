package com.example.mas.testerJednostkowy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TesterJednostkowyService {

    private final com.example.mas.testerJednostkowy.TesterJednostkowyRepository testerJednostkowyRepository;

    @Autowired
    public TesterJednostkowyService(com.example.mas.testerJednostkowy.TesterJednostkowyRepository testerJednostkowyRepository) {
        this.testerJednostkowyRepository = testerJednostkowyRepository;
    }

    public List<com.example.mas.testerJednostkowy.TesterJednostkowy> getTesterJednostkowy() {
        return testerJednostkowyRepository.findAll();
    }

    public void addNewTesterJednostkowy(com.example.mas.testerJednostkowy.TesterJednostkowy testerJednostkowy) {
        System.out.println(testerJednostkowy);
        testerJednostkowyRepository.save(testerJednostkowy);
    }

    public void deleteTesterJednostkowy(Long testerJednostkowyId) {
        boolean exists = testerJednostkowyRepository.existsById(testerJednostkowyId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + testerJednostkowyId + " nie istnieje");
        }
        testerJednostkowyRepository.deleteById(testerJednostkowyId);
    }

    @Transactional
    public void updateTesterJednostkowy(Long testerJednostkowyId,
                                        String imie) {
        com.example.mas.testerJednostkowy.TesterJednostkowy testerJednostkowy = testerJednostkowyRepository.findById(testerJednostkowyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + testerJednostkowyId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, testerJednostkowy.getImie())) {
            testerJednostkowy.setImie(imie);
        }
    }
}