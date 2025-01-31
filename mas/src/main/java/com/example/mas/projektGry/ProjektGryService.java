package com.example.mas.projektGry;

import com.example.mas.gra.Gra;
import com.example.mas.gra.GraRepository;
import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.liderZespolu.LiderZespoluService;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy;
import com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyRepository;
import jakarta.transaction.Transactional;
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
    private final LiderZespoluService liderZespoluService;
    private final PracownikStudiaRepository pracownikStudiaRepository;
    private final GraRepository graRepository;

    @Autowired
    public ProjektGryService(ProjektGryRepository projektGryRepository, PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository, ProjektGryMapper projektGryMapper, LiderZespoluService liderZespoluService, PracownikStudiaRepository pracownikStudiaRepository, GraRepository graRepository) {
        this.projektGryRepository = projektGryRepository;
        this.przedstawicielWydawcyRepository = przedstawicielWydawcyRepository;
        this.projektGryMapper = projektGryMapper;
        this.liderZespoluService = liderZespoluService;
        this.pracownikStudiaRepository = pracownikStudiaRepository;
        this.graRepository = graRepository;
    }

    public List<ProjektGryDTO> getAllProjektGry() {
        return projektGryRepository.findAll().stream().map(projektGryMapper::toDto).collect(Collectors.toList());
    }

    public ProjektGryDTO getProjektGry(Long id) {
        ProjektGry projektGry = projektGryRepository.findProjektGryById(id).orElseThrow(() -> new RuntimeException("Projekt gry nie znaleziony"));
        return projektGryMapper.toDto(projektGry);
    }

    public void addNewProjektGry(ProjektGry projektGry) {
        System.out.println(projektGry);
        projektGryRepository.save(projektGry);
    }

    public ProjektGryDoZapisuDTO addNewProjektGryDoZapisu(ProjektGryDoZapisuDTO projektGryDTO) {
        ProjektGry projektGry = projektGryMapper.toEntity(projektGryDTO);
        projektGryRepository.save(projektGry);
        System.out.println(projektGry.toString() + "pupa");
        return projektGryMapper.projektGryDoZapisuDTO(projektGry);
    }

    public void deleteProjektGry(Long projektGryId) {
        boolean exists = projektGryRepository.existsById(projektGryId);
        if (!exists) {
            throw new IllegalStateException(
                    "ProjektGry " + projektGryId + " nie istnieje");
        }
        ProjektGry projektGry = projektGryRepository.findProjektGryById(projektGryId).orElse(null);
        pracownikStudiaRepository.findAllByProjektGryId(projektGryId).stream().forEach(pracownikStudia -> {
            projektGry.removePracownikStudia(pracownikStudia);
            pracownikStudiaRepository.save(pracownikStudia);
        });
        Gra gra = graRepository.findGraByProjektGryId(projektGryId).orElse(null);
        if (gra != null) {
            gra.setProjektGry(null);
            graRepository.save(gra);
        }
        projektGryRepository.deleteById(projektGryId);
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

    public ProjektGryDTO assignProjektGry(Long przedstawicielWydawcyId, Long projektGryId){
        PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyRepository.findById(przedstawicielWydawcyId)
                .orElseThrow(() -> new IllegalArgumentException("Przedstawiciel Wydawcy z id " + przedstawicielWydawcyId + " nie istnieje"));

        ProjektGry projektGry = projektGryRepository.findProjektGryById(projektGryId)
                .orElseThrow(() -> new IllegalArgumentException("Projekt gry z id " + projektGryId + " nie istnieje"));

        projektGry.setPrzedstawicielWydawcy(przedstawicielWydawcy);
        przedstawicielWydawcy.getProjektyGier().add(projektGry);

        projektGryRepository.save(projektGry);
        przedstawicielWydawcyRepository.save(przedstawicielWydawcy);
        return projektGryMapper.toDto(projektGry);
    }

    public void updateProjektGry(Long projektGryId, String sprzet, Long budzet, double kosztMarketingu, double kosztUtrzymania, Long liderZespoluID) {
        ProjektGry projektGry = projektGryRepository.findProjektGryById(projektGryId).orElseThrow(() -> new RuntimeException("Projekt gry nie znaleziony"));

        LiderZespolu lider = liderZespoluService.getLiderZespoluById(liderZespoluID);
        projektGry.setBudzet(budzet);
        projektGry.setKosztUtrzymaniaZespolu(kosztUtrzymania);
        projektGry.setKosztMarketingu(kosztMarketingu);
        projektGry.setWymaganySprzet(sprzet);
        projektGry.setLiderZespolu(lider);
        projektGryRepository.save(projektGry);
    }

    public List<ProjektGry> findByLiderZespolu_Id(Long id){
        return projektGryRepository.findAllByLiderZespoluId(id);
    }
}
