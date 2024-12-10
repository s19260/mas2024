package com.example.mas.projektGry;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjektGryService {

    private final com.example.mas.projektGry.ProjektGryRepository projektGryRepository;

    @Autowired
    public ProjektGryService(com.example.mas.projektGry.ProjektGryRepository projektGryRepository) {
        this.projektGryRepository = projektGryRepository;
    }

    public List<com.example.mas.projektGry.ProjektGry> getProjektGry() {
        return projektGryRepository.findAll();
    }

    public ProjektGry addNewProjektGry(ProjektGry projektGry) {
        System.out.println(projektGry);
        projektGryRepository.save(projektGry);
        return projektGry;
    }

    public void deleteProjektGry(Long projektGryId) {
        boolean exists = projektGryRepository.existsById(projektGryId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + projektGryId + " nie istnieje");
        }
        projektGryRepository.deleteById(projektGryId);
    }

    @Transactional
//    public void updateProjektGry(Long projektGryId,
//                                String imie) {
//        com.example.mas.projektGry.ProjektGry projektGry = projektGryRepository.findById(projektGryId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "Pracownik studia " + projektGryId + " nie istnieje"));
//        if (imie != null &&
//                !imie.isEmpty() &&
//                !Objects.equals(imie, projektGry.getImie())) {
//            projektGry.setImie(imie);
//        }
//    }

    public Optional<ProjektGry> updateProjektGry(ProjektGry projektGry) {
        Optional<ProjektGry> znajdzProjektGry = projektGryRepository.findById(projektGry.getId());
//              .orElseThrow(() -> new IllegalStateException(
//                       "Pracownik studia nie istnieje"));

        return znajdzProjektGry;
    }
}
