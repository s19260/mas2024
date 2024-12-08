package com.example.mas.testerEndToEnd;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TesterEndToEndService {

    private final com.example.mas.testerEndToEnd.TesterEndToEndRepository testerEndToEndRepository;

    @Autowired
    public TesterEndToEndService(com.example.mas.testerEndToEnd.TesterEndToEndRepository testerEndToEndRepository) {
        this.testerEndToEndRepository = testerEndToEndRepository;
    }

    public List<com.example.mas.testerEndToEnd.TesterEndToEnd> getTesterEndToEnd() {
        return testerEndToEndRepository.findAll();
    }

    public void addNewTesterEndToEnd(com.example.mas.testerEndToEnd.TesterEndToEnd testerEndToEnd) {
        System.out.println(testerEndToEnd);
        testerEndToEndRepository.save(testerEndToEnd);
    }

    public void deleteTesterEndToEnd(Long testerEndToEndId) {
        boolean exists = testerEndToEndRepository.existsById(testerEndToEndId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + testerEndToEndId + " nie istnieje");
        }
        testerEndToEndRepository.deleteById(testerEndToEndId);
    }

    @Transactional
    public void updateTesterEndToEnd(Long testerEndToEndId,
                                     String imie) {
        com.example.mas.testerEndToEnd.TesterEndToEnd testerEndToEnd = testerEndToEndRepository.findById(testerEndToEndId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + testerEndToEndId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, testerEndToEnd.getImie())) {
            testerEndToEnd.setImie(imie);
        }
    }
}