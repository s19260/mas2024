package com.example.mas.deweloper;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeweloperService {

    private final com.example.mas.deweloper.DeweloperRepository deweloperRepository;

    @Autowired
    public DeweloperService(com.example.mas.deweloper.DeweloperRepository deweloperRepository) {
        this.deweloperRepository = deweloperRepository;
    }

    public List<com.example.mas.deweloper.Deweloper> getDeweloper() {
        return deweloperRepository.findAll();
    }

    public void addNewDeweloper(com.example.mas.deweloper.Deweloper deweloper) {
        System.out.println(deweloper);
        deweloperRepository.save(deweloper);
    }

    public void deleteDeweloper(Long deweloperId) {
        boolean exists = deweloperRepository.existsById(deweloperId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + deweloperId + " nie istnieje");
        }
        deweloperRepository.deleteById(deweloperId);
    }

    @Transactional
    public void updateDeweloper(Long deweloperId,
                                String imie) {
        com.example.mas.deweloper.Deweloper deweloper = deweloperRepository.findById(deweloperId)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik studia " + deweloperId + " nie istnieje"));
        if (imie != null &&
                !imie.isEmpty() &&
                !Objects.equals(imie, deweloper.getImie())) {
            deweloper.setImie(imie);
        }
    }
}
