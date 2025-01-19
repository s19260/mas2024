package com.example.mas.gra;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GraService {

    private final GraRepository graRepository;
    private final GraMapper graMapper;


    public List<GraDTO> getGra() {
        return graRepository.findAll().stream().map(graMapper::toDto).collect(Collectors.toList());
    }

    public void addNewGra(Gra gra) {
        System.out.println(gra);
        graRepository.save(gra);
    }

    public List<GraDTO> getGryWhereProjektNull(){
        return graRepository.findAllGraWhereProjektGryIsNull().stream().map(graMapper::toDto).collect(Collectors.toList());
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
