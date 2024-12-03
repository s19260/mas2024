package com.example.mas.projektGry;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProjektGryService {

    private final ProjektGryRepository projektGryRepository;

    @Autowired
    public ProjektGryService(ProjektGryRepository projektGryRepository) {
        this.projektGryRepository = projektGryRepository;
    }

    public List<ProjektGry> getProjektGry() {
        return projektGryRepository.findAll();
    }

    public void addNewProjektGry(ProjektGry projektGry) {
        System.out.println(projektGry);
        projektGryRepository.save(projektGry);
    }

    public void deleteProjektGry(Long projektGryId) {
        boolean exists = projektGryRepository.existsById(projektGryId);
        if(!exists){
            throw new IllegalStateException(
                    "ProjektGry " + projektGryId + " nie istnieje");
        }
        projektGryRepository.deleteById(projektGryId);
    }

    @Transactional
    public void updateProjektGry(Long projektGryId,
                                 String liderZespolu) {
        ProjektGry projektGry = projektGryRepository.findById(projektGryId)
                .orElseThrow(() -> new IllegalStateException(
                        "ProjektGry " + projektGryId + " nie istnieje"));
//        if (liderZespolu != null &&
//                !liderZespolu.isEmpty() &&
//                !Objects.equals(liderZespolu, projektGry.liderZespolu())) {
//            projektGry.setLiderZespolu(liderZespolu);
//        }
    }
}
