package com.example.mas.przedstawicielWydawcy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/przedstawicielWydawcy")
public class PrzedstawicielWydawcyController {

    private final com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyService przedstawicielWydawcyService;

    @Autowired
    public PrzedstawicielWydawcyController(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyService przedstawicielWydawcyService) {
        this.przedstawicielWydawcyService = przedstawicielWydawcyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PrzedstawicielWydawcy>> getAllPrzedstawicielWydawcy() {
        List<PrzedstawicielWydawcy> przedstawicielWydawcyzy = przedstawicielWydawcyService.getPrzedstawicielWydawcy();
        return new ResponseEntity<>(przedstawicielWydawcyzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PrzedstawicielWydawcy> getPrzedstawicielWydawcyById(@PathVariable ("id") Long id) {
        PrzedstawicielWydawcy przedstawicielWydawcy = przedstawicielWydawcyService.getPrzedstawicielWydawcy().get(Math.toIntExact(id));
        return new ResponseEntity<>(przedstawicielWydawcy, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PrzedstawicielWydawcy> addPrzedstawicielWydawcy(@RequestBody PrzedstawicielWydawcy przedstawicielWydawcy) {
        PrzedstawicielWydawcy nowyPrzedstawicielWydawcy = przedstawicielWydawcyService.addNewPrzedstawicielWydawcy(przedstawicielWydawcy);
        return new ResponseEntity<>(przedstawicielWydawcy, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PrzedstawicielWydawcy> updatePrzedstawicielWydawcy(@RequestBody PrzedstawicielWydawcy przedstawicielWydawcy) {
        Optional<PrzedstawicielWydawcy> zaktualizujPrzedstawicielWydawcy = przedstawicielWydawcyService.updatePrzedstawicielWydawcy(przedstawicielWydawcy);
        return new ResponseEntity<>(przedstawicielWydawcy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{przedstawicielWydawcyId}")
    public ResponseEntity<?> deletePrzedstawicielWydawcy(@PathVariable ("przedstawicielWydawcyId") Long przedstawicielWydawcyId) {
        przedstawicielWydawcyService.deletePrzedstawicielWydawcy(przedstawicielWydawcyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<PrzedstawicielWydawcy> getPrzedstawicielWydawcy() {
//        return przedstawicielWydawcyService.getPrzedstawicielWydawcy();
//    }
//
//    @PostMapping
//    public void registerNewPrzedstawicielWydawcy (@RequestBody PrzedstawicielWydawcy przedstawicielWydawcy) {
//        przedstawicielWydawcyService.addNewPrzedstawicielWydawcy(przedstawicielWydawcy);
//    }
//
//    @DeleteMapping(path = "{przedstawicielWydawcyId}")
//    public void deletePrzedstawicielWydawcy (@PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyID) {
//        przedstawicielWydawcyService.deletePrzedstawicielWydawcy(przedstawicielWydawcyID);
//    }
//
//    @PutMapping(path = "{przedstawicielWydawcyId}")
//    public void updatePrzedstawicielWydawcy(
//            @PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyId,
//            @RequestParam(required = false) String imie) {
//        przedstawicielWydawcyService.updatePrzedstawicielWydawcy(przedstawicielWydawcyId, imie);
//    }
}
