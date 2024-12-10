package com.example.mas.szefStudia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/szefStudia")
public class SzefStudiaController {

    private final com.example.mas.szefStudia.SzefStudiaService szefStudiaService;

    @Autowired
    public SzefStudiaController(com.example.mas.szefStudia.SzefStudiaService szefStudiaService) {
        this.szefStudiaService = szefStudiaService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SzefStudia>> getAllSzefStudia() {
        List<SzefStudia> szefStudiazy = szefStudiaService.getSzefStudia();
        return new ResponseEntity<>(szefStudiazy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SzefStudia> getSzefStudiaById(@PathVariable ("id") Long id) {
        SzefStudia szefStudia = szefStudiaService.getSzefStudia().get(Math.toIntExact(id));
        return new ResponseEntity<>(szefStudia, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SzefStudia> addSzefStudia(@RequestBody SzefStudia szefStudia) {
        SzefStudia nowySzefStudia = szefStudiaService.addNewSzefStudia(szefStudia);
        return new ResponseEntity<>(szefStudia, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SzefStudia> updateSzefStudia(@RequestBody SzefStudia szefStudia) {
        Optional<SzefStudia> zaktualizujSzefStudia = szefStudiaService.updateSzefStudia(szefStudia);
        return new ResponseEntity<>(szefStudia, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{szefStudiaId}")
    public ResponseEntity<?> deleteSzefStudia(@PathVariable ("szefStudiaId") Long szefStudiaId) {
        szefStudiaService.deleteSzefStudia(szefStudiaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<SzefStudia> getSzefStudia() {
//        return szefStudiaService.getSzefStudia();
//    }
//
//    @PostMapping
//    public void registerNewSzefStudia (@RequestBody SzefStudia szefStudia) {
//        szefStudiaService.addNewSzefStudia(szefStudia);
//    }
//
//    @DeleteMapping(path = "{szefStudiaId}")
//    public void deleteSzefStudia (@PathVariable("szefStudiaId") Long szefStudiaID) {
//        szefStudiaService.deleteSzefStudia(szefStudiaID);
//    }
//
//    @PutMapping(path = "{szefStudiaId}")
//    public void updateSzefStudia(
//            @PathVariable("szefStudiaId") Long szefStudiaId,
//            @RequestParam(required = false) String imie) {
//        szefStudiaService.updateSzefStudia(szefStudiaId, imie);
//    }
}
