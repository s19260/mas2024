package com.example.mas.pracownikStudia;

import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import com.example.mas.projektGry.ProjektGryRepository;
import com.example.mas.projektGry.ProjektGryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class PracownikStudiaService {

    private final PracownikStudiaRepository pracownikStudiaRepository;
    private final PracownikStudiaMapper pracownikStudiaMapper;
    private final ProjektGryRepository projektGryRepository;
    private final ProjektGryService projektGryService;

    @Autowired
    public PracownikStudiaService(PracownikStudiaRepository pracownikStudiaRepository, PracownikStudiaMapper pracownikStudiaMapper, ProjektGryRepository projektGryRepository, ProjektGryService projektGryService) {
        this.pracownikStudiaRepository = pracownikStudiaRepository;
        this.pracownikStudiaMapper = pracownikStudiaMapper;
        this.projektGryRepository = projektGryRepository;
        this.projektGryService = projektGryService;
    }

    public List<PracownikStudiaDTO> getAllPracownikStudia() {
        return pracownikStudiaRepository.findAll().stream().map(pracownikStudiaMapper::toDto).collect(Collectors.toList());
    }

    public PracownikStudiaDTO getPracownikStudia(Long id) {
        PracownikStudia pracownikStudia = pracownikStudiaRepository.findPracownikStudiaById(id).orElseThrow(() -> new RuntimeException("Pracownik studia nie znaleziony"));
        return pracownikStudiaMapper.toDto(pracownikStudia);
    }

    public List<PracownikStudia> getPracownikStudia() {
        return pracownikStudiaRepository.findAll();
    }

    public void addNewPracownikStudia(PracownikStudia pracownikStudia) {
        System.out.println(pracownikStudia);
        pracownikStudiaRepository.save(pracownikStudia);
    }

    public PracownikStudiaDTO addNewPracownikStudia(PracownikStudiaDoZapisuDTO pracownikStudia) {
        PracownikStudia ps = pracownikStudiaMapper.toEntity(pracownikStudia);
        pracownikStudiaRepository.save(ps);
        return pracownikStudiaMapper.toDto(ps);
    }

    public void deletePracownikStudia(Long pracownikStudiaId) {
        boolean exists = pracownikStudiaRepository.existsById(pracownikStudiaId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + pracownikStudiaId + " nie istnieje");
        }
        PracownikStudia pracownikStudia = pracownikStudiaRepository.findPracownikStudiaById(pracownikStudiaId).orElseThrow(() -> new RuntimeException("Pracownik studia nie znaleziony"));
        if(pracownikStudia.getProjektGry() != null){
           if(pracownikStudia.getProjektGry().getLiderZespolu() != null){


            if(pracownikStudia.getProjektGry().getLiderZespolu().getId() == pracownikStudiaId)
            {
                List<ProjektGry> projekty = projektGryService.findByLiderZespolu_Id(pracownikStudiaId);
                System.out.println("dupa " + projekty);
                projekty.stream().forEach(projektGry -> {
                    projektGry.setLiderZespolu(null);
                });
            }
           }
        ProjektGry projektGry = pracownikStudia.getProjektGry();
        projektGry.removePracownikStudia(pracownikStudia);
        projektGryRepository.save(projektGry);
        pracownikStudiaRepository.deleteById(pracownikStudiaId);
        }
        else
            pracownikStudiaRepository.deleteById(pracownikStudiaId);

    }

    @Transactional
    public void updatePracownikStudia(Long pracownikStudiaId,
                                      String imie,
                                      String nazwisko) {
        PracownikStudia pracownikStudia = pracownikStudiaRepository.findById(pracownikStudiaId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + pracownikStudiaId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, pracownikStudia.getImie())) {
            pracownikStudia.setImie(imie);
        }

        pracownikStudia.setNazwisko(nazwisko);
        pracownikStudiaRepository.save(pracownikStudia);
    }
}
