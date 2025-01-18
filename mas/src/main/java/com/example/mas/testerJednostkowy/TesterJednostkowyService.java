package com.example.mas.testerJednostkowy;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TesterJednostkowyService {

    private final com.example.mas.testerJednostkowy.TesterJednostkowyRepository testerJednostkowyRepository;
    private final TesterJednostkowyMapper testerJednostkowyMapper;

    @Autowired
    public TesterJednostkowyService(com.example.mas.testerJednostkowy.TesterJednostkowyRepository testerJednostkowyRepository, TesterJednostkowyMapper testerJednostkowyMapper) {
        this.testerJednostkowyMapper = testerJednostkowyMapper;
        this.testerJednostkowyRepository = testerJednostkowyRepository;
    }

    public List<com.example.mas.testerJednostkowy.TesterJednostkowy> getTesterJednostkowy() {
        return testerJednostkowyRepository.findAll();
    }

    public List<com.example.mas.testerJednostkowy.TesterJednostkowyDTO> getTesterJednostkowyDTO() {
        return testerJednostkowyRepository.findAll().stream().map(testerJednostkowyMapper::toDto).collect(Collectors.toList());
    }

    public TesterJednostkowy getTesterJednostkowyById(Long id) {
        return testerJednostkowyRepository.findById(id).orElse(null);
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
