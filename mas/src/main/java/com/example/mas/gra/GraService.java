package com.example.mas.gra;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GraService {

    private final GraRepository graRepository;

    @Autowired
    public GraService(GraRepository graRepository) {
        this.graRepository = graRepository;
    }

    public List<Gra> getGra() {
        return graRepository.findAll();
    }

    public void addNewGra(Gra gra) {
        System.out.println(gra);
        graRepository.save(gra);
    }

    public void deleteGra(Long graId) {
        boolean exists = graRepository.existsById(graId);
        if(!exists){
            throw new IllegalStateException(
                    "Gra " + graId + " nie istnieje");
        }
        graRepository.deleteById(graId);
    }

    @Transactional
    public void updateGra(Long graId,
                          String nazwa) {
        Gra gra = graRepository.findById(graId)
                .orElseThrow(() -> new IllegalStateException(
                        "Gra " + graId + " nie istnieje"));
        if (nazwa != null &&
                !nazwa.isEmpty() &&
                !Objects.equals(nazwa, gra.getNazwa())) {
            gra.setNazwa(nazwa);
        }
    }
}
