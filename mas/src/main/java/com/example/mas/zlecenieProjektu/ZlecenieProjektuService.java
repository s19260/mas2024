package com.example.mas.zlecenieProjektu;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ZlecenieProjektuService {

    private final ZlecenieProjektuRepository zlecenieProjektuRepository;

    @Autowired
    public ZlecenieProjektuService(ZlecenieProjektuRepository zlecenieProjektuRepository) {
        this.zlecenieProjektuRepository = zlecenieProjektuRepository;
    }

    public List<ZlecenieProjektu> getZlecenieProjektu() {
        return zlecenieProjektuRepository.findAll();
    }

    public void addNewZlecenieProjektu(ZlecenieProjektu zlecenieProjektu) {
        System.out.println(zlecenieProjektu);
        zlecenieProjektuRepository.save(zlecenieProjektu);
    }

    public void deleteZlecenieProjektu(Long zlecenieProjektuId) {
        boolean exists = zlecenieProjektuRepository.existsById(zlecenieProjektuId);
        if(!exists){
            throw new IllegalStateException(
                    "ZlecenieProjektu " + zlecenieProjektuId + " nie istnieje");
        }
        zlecenieProjektuRepository.deleteById(zlecenieProjektuId);
    }

    @Transactional
    public void updateZlecenieProjektu(Long zlecenieProjektuId,
                                       String liderZespolu) {
        ZlecenieProjektu zlecenieProjektu = zlecenieProjektuRepository.findById(zlecenieProjektuId)
                .orElseThrow(() -> new IllegalStateException(
                        "ZlecenieProjektu " + zlecenieProjektuId + " nie istnieje"));
//        if (liderZespolu != null &&
//                !liderZespolu.isEmpty() &&
//                !Objects.equals(liderZespolu, zlecenieProjektu.liderZespolu())) {
//            zlecenieProjektu.setLiderZespolu(liderZespolu);
//        }
    }
}
