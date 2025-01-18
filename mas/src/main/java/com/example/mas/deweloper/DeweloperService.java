package com.example.mas.deweloper;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDoZapisuDTO;
import com.example.mas.pracownikStudia.PracownikStudiaMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeweloperService {

    private final com.example.mas.deweloper.DeweloperRepository deweloperRepository;
    private final DeweloperMapper deweloperMapper;

    @Autowired
    public DeweloperService(com.example.mas.deweloper.DeweloperRepository deweloperRepository, DeweloperMapper deweloperMapper) {
        this.deweloperRepository = deweloperRepository;
        this.deweloperMapper = deweloperMapper;
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
    public DeweloperDTO addNewDeweloper(DeweloperDoZapisuDTO deweloper) {
        Deweloper d = deweloperMapper.toEntity(deweloper);
        deweloperRepository.save(d);
        return deweloperMapper.toDto(d);
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
