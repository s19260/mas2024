package com.example.mas.testerIntegracyjny;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TesterIntegracyjnyService {

    private final com.example.mas.testerIntegracyjny.TesterIntegracyjnyRepository testerIntegracyjnyRepository;

    @Autowired
    public TesterIntegracyjnyService(com.example.mas.testerIntegracyjny.TesterIntegracyjnyRepository testerIntegracyjnyRepository) {
        this.testerIntegracyjnyRepository = testerIntegracyjnyRepository;
    }

    public List<com.example.mas.testerIntegracyjny.TesterIntegracyjny> getTesterIntegracyjny() {
        return testerIntegracyjnyRepository.findAll();
    }

    public void addNewTesterIntegracyjny(com.example.mas.testerIntegracyjny.TesterIntegracyjny testerIntegracyjny) {
        System.out.println(testerIntegracyjny);
        testerIntegracyjnyRepository.save(testerIntegracyjny);
    }

    public void deleteTesterIntegracyjny(Long testerIntegracyjnyId) {
        boolean exists = testerIntegracyjnyRepository.existsById(testerIntegracyjnyId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + testerIntegracyjnyId + " nie istnieje");
        }
        testerIntegracyjnyRepository.deleteById(testerIntegracyjnyId);
    }

    @Transactional
    public void updateTesterIntegracyjny(Long testerIntegracyjnyId,
                                         String imie) {
        com.example.mas.testerIntegracyjny.TesterIntegracyjny testerIntegracyjny = testerIntegracyjnyRepository.findById(testerIntegracyjnyId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + testerIntegracyjnyId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, testerIntegracyjny.getImie())) {
            testerIntegracyjny.setImie(imie);
        }
    }
}
