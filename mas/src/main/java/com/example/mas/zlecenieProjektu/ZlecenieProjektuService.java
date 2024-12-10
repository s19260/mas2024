package com.example.mas.zlecenieProjektu;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ZlecenieProjektuService {

    private final com.example.mas.zlecenieProjektu.ZlecenieProjektuRepository zlecenieProjektuRepository;

    @Autowired
    public ZlecenieProjektuService(com.example.mas.zlecenieProjektu.ZlecenieProjektuRepository zlecenieProjektuRepository) {
        this.zlecenieProjektuRepository = zlecenieProjektuRepository;
    }

    public List<com.example.mas.zlecenieProjektu.ZlecenieProjektu> getZlecenieProjektu() {
        return zlecenieProjektuRepository.findAll();
    }

    public ZlecenieProjektu addNewZlecenieProjektu(ZlecenieProjektu zlecenieProjektu) {
        System.out.println(zlecenieProjektu);
        zlecenieProjektuRepository.save(zlecenieProjektu);
        return zlecenieProjektu;
    }

    public void deleteZlecenieProjektu(Long zlecenieProjektuId) {
        boolean exists = zlecenieProjektuRepository.existsById(zlecenieProjektuId);
        if(!exists){
            throw new IllegalStateException(
                    "Pracownik studia " + zlecenieProjektuId + " nie istnieje");
        }
        zlecenieProjektuRepository.deleteById(zlecenieProjektuId);
    }

    @Transactional
//    public void updateZlecenieProjektu(Long zlecenieProjektuId,
//                                String imie) {
//        com.example.mas.zlecenieProjektu.ZlecenieProjektu zlecenieProjektu = zlecenieProjektuRepository.findById(zlecenieProjektuId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "Pracownik studia " + zlecenieProjektuId + " nie istnieje"));
//        if (imie != null &&
//                !imie.isEmpty() &&
//                !Objects.equals(imie, zlecenieProjektu.getImie())) {
//            zlecenieProjektu.setImie(imie);
//        }
//    }

    public Optional<ZlecenieProjektu> updateZlecenieProjektu(ZlecenieProjektu zlecenieProjektu) {
        Optional<ZlecenieProjektu> znajdzZlecenieProjektu = zlecenieProjektuRepository.findById(zlecenieProjektu.getId());
//              .orElseThrow(() -> new IllegalStateException(
//                       "Pracownik studia nie istnieje"));

        return znajdzZlecenieProjektu;
    }
}
