package com.example.mas.tester;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TesterService {

    private final com.example.mas.tester.TesterRepository testerRepository;

    @Autowired
    public TesterService(com.example.mas.tester.TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public List<com.example.mas.tester.Tester> getTester() {
        return testerRepository.findAll();
    }

    public void addNewTester(com.example.mas.tester.Tester tester) {
        System.out.println(tester);
        testerRepository.save(tester);
    }

    public void deleteTester(Long testerId) {
        boolean exists = testerRepository.existsById(testerId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + testerId + " nie istnieje");
        }
        testerRepository.deleteById(testerId);
    }

    @Transactional
    public void updateTester(Long testerId,
                             String imie) {
        com.example.mas.tester.Tester tester = testerRepository.findById(testerId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + testerId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, tester.getImie())) {
            tester.setImie(imie);
        }
    }
}
