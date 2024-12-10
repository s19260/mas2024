package com.example.mas.projektGry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/projektGry")
public class ProjektGryController {

    private final com.example.mas.projektGry.ProjektGryService projektGryService;

    @Autowired
    public ProjektGryController(com.example.mas.projektGry.ProjektGryService projektGryService) {
        this.projektGryService = projektGryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjektGry>> getAllProjektGry() {
        List<ProjektGry> projektGryzy = projektGryService.getProjektGry();
        return new ResponseEntity<>(projektGryzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProjektGry> getProjektGryById(@PathVariable ("id") Long id) {
        ProjektGry projektGry = projektGryService.getProjektGry().get(Math.toIntExact(id));
        return new ResponseEntity<>(projektGry, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ProjektGry> addProjektGry(@RequestBody ProjektGry projektGry) {
        ProjektGry nowyProjektGry = projektGryService.addNewProjektGry(projektGry);
        return new ResponseEntity<>(projektGry, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjektGry> updateProjektGry(@RequestBody ProjektGry projektGry) {
        Optional<ProjektGry> zaktualizujProjektGry = projektGryService.updateProjektGry(projektGry);
        return new ResponseEntity<>(projektGry, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{projektGryId}")
    public ResponseEntity<?> deleteProjektGry(@PathVariable ("projektGryId") Long projektGryId) {
        projektGryService.deleteProjektGry(projektGryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<ProjektGry> getProjektGry() {
//        return projektGryService.getProjektGry();
//    }
//
//    @PostMapping
//    public void registerNewProjektGry (@RequestBody ProjektGry projektGry) {
//        projektGryService.addNewProjektGry(projektGry);
//    }
//
//    @DeleteMapping(path = "{projektGryId}")
//    public void deleteProjektGry (@PathVariable("projektGryId") Long projektGryID) {
//        projektGryService.deleteProjektGry(projektGryID);
//    }
//
//    @PutMapping(path = "{projektGryId}")
//    public void updateProjektGry(
//            @PathVariable("projektGryId") Long projektGryId,
//            @RequestParam(required = false) String imie) {
//        projektGryService.updateProjektGry(projektGryId, imie);
//    }
}
