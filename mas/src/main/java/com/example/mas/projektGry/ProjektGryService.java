package com.example.mas.projektGry;

import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjektGryService {

    private final ProjektGryRepository projektGryRepository;
    private final PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository;
    private final ProjektGryMapper projektGryMapper;

    @Autowired
    public ProjektGryService(ProjektGryRepository projektGryRepository, PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository, ProjektGryMapper projektGryMapper) {
        this.projektGryRepository = projektGryRepository;
        this.przedstawicielWydawcyRepository = przedstawicielWydawcyRepository;
        this.projektGryMapper = projektGryMapper;
    }

    public List<ProjektGryDTO> getAllProjektGry() {
        return projektGryRepository.findAll().stream().map(projektGryMapper::toDto).collect(Collectors.toList());
    }

    public ProjektGry getProjektGry(Long id) {
        return projektGryRepository.findProjektGryById(id).orElseThrow(() -> new RuntimeException("Projekt gry nie znaleziony"));
    }


    public void addNewProjektGry(ProjektGry projektGry) {
        System.out.println(projektGry);
        projektGryRepository.save(projektGry);
    }

    public void deleteProjektGry(Long projektGryId) {
        boolean exists = projektGryRepository.existsById(projektGryId);
        if (!exists) {
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

    public ProjektGry createAndAssignProjektGry(Long przedstawicielWydawcyId, ProjektGry projektGry) {
        PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(przedstawicielWydawcyId)
                .orElseThrow(() -> new IllegalArgumentException("Przedstawiciel Wydawcy z id " + przedstawicielWydawcyId + " nie istnieje"));

        przedstawicielWydawcy.addProjektGry(projektGry);
        projektGry.setPrzedstawicielWydawcy(przedstawicielWydawcy);
        przedstawicielWydawcyRepository.save(przedstawicielWydawcy);
        projektGryRepository.save(projektGry);

        return projektGry;
    }

    public ProjektGry assignProjektGry(Long przedstawicielWydawcyId, Long projektGryId){
        PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(przedstawicielWydawcyId)
                .orElseThrow(() -> new IllegalArgumentException("Przedstawiciel Wydawcy z id " + przedstawicielWydawcyId + " nie istnieje"));

        ProjektGry projektGry = projektGryRepository.findProjektGryById(projektGryId)
                .orElseThrow(() -> new IllegalArgumentException("Projekt gry z id " + projektGryId + " nie istnieje"));

        projektGry.setPrzedstawicielWydawcy(przedstawicielWydawcy);
        przedstawicielWydawcy.getProjektyGier().add(projektGry);

        projektGryRepository.save(projektGry);
        przedstawicielWydawcyRepository.save(przedstawicielWydawcy);

        return projektGry;
    }

}
