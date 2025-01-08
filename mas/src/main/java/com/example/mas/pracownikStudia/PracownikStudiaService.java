package com.example.mas.pracownikStudia;

import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
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

    @Autowired
    public PracownikStudiaService(PracownikStudiaRepository pracownikStudiaRepository, PracownikStudiaMapper pracownikStudiaMapper) {
        this.pracownikStudiaRepository = pracownikStudiaRepository;
        this.pracownikStudiaMapper = pracownikStudiaMapper;
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

    public void deletePracownikStudia(Long pracownikStudiaId) {
        boolean exists = pracownikStudiaRepository.existsById(pracownikStudiaId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + pracownikStudiaId + " nie istnieje");
        }
        pracownikStudiaRepository.deleteById(pracownikStudiaId);
    }

    @Transactional
    public void updatePracownikStudia(Long pracownikStudiaId,
                                      String imie) {
        PracownikStudia pracownikStudia = pracownikStudiaRepository.findById(pracownikStudiaId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + pracownikStudiaId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, pracownikStudia.getImie())) {
            pracownikStudia.setImie(imie);
        }
    }
}
