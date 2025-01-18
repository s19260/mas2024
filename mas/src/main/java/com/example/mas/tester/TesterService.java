package com.example.mas.tester;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TesterService {

    private final com.example.mas.tester.TesterRepository testerRepository;
    private final TesterMapper testerMapper;

    @Autowired
    public TesterService(com.example.mas.tester.TesterRepository testerRepository, TesterMapper testerMapper) {
        this.testerMapper = testerMapper;
        this.testerRepository = testerRepository;
    }

    public List<com.example.mas.tester.Tester> getTester() {
        return testerRepository.findAll();
    }

    public List<com.example.mas.tester.TesterDTO> getTesterDTO() {
        return testerRepository.findAll().stream().map(testerMapper::toDto).collect(Collectors.toList());
    }

    public Tester getTesterById(Long id) {
        return testerRepository.findById(id).orElse(null);
    }


    public TesterDTO addNewTester(TesterDTO tester) {
        System.out.println(tester);
        Tester testerEntity = testerMapper.toEntity(tester);
        return testerMapper.toDto(testerRepository.save(testerEntity));
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
