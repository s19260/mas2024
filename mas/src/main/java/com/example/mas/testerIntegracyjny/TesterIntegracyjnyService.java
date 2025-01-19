package com.example.mas.testerIntegracyjny;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TesterIntegracyjnyService {

    private final com.example.mas.testerIntegracyjny.TesterIntegracyjnyRepository testerIntegracyjnyRepository;
    private final TesterIntegracyjnyMapper testerIntegracyjnyMapper;

    @Autowired
    public TesterIntegracyjnyService(com.example.mas.testerIntegracyjny.TesterIntegracyjnyRepository testerIntegracyjnyRepository, TesterIntegracyjnyMapper testerIntegracyjnyMapper) {
        this.testerIntegracyjnyMapper = testerIntegracyjnyMapper;
        this.testerIntegracyjnyRepository = testerIntegracyjnyRepository;
    }

    public List<com.example.mas.testerIntegracyjny.TesterIntegracyjny> getTesterIntegracyjny() {
        return testerIntegracyjnyRepository.findAll();
    }

    public List<com.example.mas.testerIntegracyjny.TesterIntegracyjnyDTO> getTesterIntegracyjnyDTO() {
        return testerIntegracyjnyRepository.findAll().stream().map(testerIntegracyjnyMapper::toDto).collect(Collectors.toList());
    }

    public TesterIntegracyjny getTesterIntegracyjnyById(Long id) {
        return testerIntegracyjnyRepository.findById(id).orElse(null);
    }


    public TesterIntegracyjnyDTO addNewTesterIntegracyjny(TesterIntegracyjnyDTO testerIntegracyjny) {
        System.out.println(testerIntegracyjny);
        TesterIntegracyjny testerIntegracyjny1 = testerIntegracyjnyMapper.toEntity(testerIntegracyjny);
        return testerIntegracyjnyMapper.toDto(testerIntegracyjnyRepository.save(testerIntegracyjny1));
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
