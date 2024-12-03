package com.example.mas.pracownikStudia;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PracownikStudiaService {

    private final PracownikStudiaRepository pracownikStudiaRepository;

    @Autowired
    public PracownikStudiaService(PracownikStudiaRepository pracownikStudiaRepository) {
        this.pracownikStudiaRepository = pracownikStudiaRepository;
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
