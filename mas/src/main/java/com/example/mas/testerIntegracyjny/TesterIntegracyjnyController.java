package com.example.mas.testerIntegracyjny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/testerIntegracyjny")
public class TesterIntegracyjnyController {

    private final com.example.mas.testerIntegracyjny.TesterIntegracyjnyService testerIntegracyjnyService;

    @Autowired
    public TesterIntegracyjnyController(com.example.mas.testerIntegracyjny.TesterIntegracyjnyService testerIntegracyjnyService) {
        this.testerIntegracyjnyService = testerIntegracyjnyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TesterIntegracyjny>> getAllTesterIntegracyjny() {
        List<TesterIntegracyjny> testerIntegracyjnyzy = testerIntegracyjnyService.getTesterIntegracyjny();
        return new ResponseEntity<>(testerIntegracyjnyzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TesterIntegracyjny> getTesterIntegracyjnyById(@PathVariable ("id") Long id) {
        TesterIntegracyjny testerIntegracyjny = testerIntegracyjnyService.getTesterIntegracyjny().get(Math.toIntExact(id));
        return new ResponseEntity<>(testerIntegracyjny, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TesterIntegracyjny> addTesterIntegracyjny(@RequestBody TesterIntegracyjny testerIntegracyjny) {
        TesterIntegracyjny nowyTesterIntegracyjny = testerIntegracyjnyService.addNewTesterIntegracyjny(testerIntegracyjny);
        return new ResponseEntity<>(testerIntegracyjny, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TesterIntegracyjny> updateTesterIntegracyjny(@RequestBody TesterIntegracyjny testerIntegracyjny) {
        Optional<TesterIntegracyjny> zaktualizujTesterIntegracyjny = testerIntegracyjnyService.updateTesterIntegracyjny(testerIntegracyjny);
        return new ResponseEntity<>(testerIntegracyjny, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{testerIntegracyjnyId}")
    public ResponseEntity<?> deleteTesterIntegracyjny(@PathVariable ("testerIntegracyjnyId") Long testerIntegracyjnyId) {
        testerIntegracyjnyService.deleteTesterIntegracyjny(testerIntegracyjnyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<TesterIntegracyjny> getTesterIntegracyjny() {
//        return testerIntegracyjnyService.getTesterIntegracyjny();
//    }
//
//    @PostMapping
//    public void registerNewTesterIntegracyjny (@RequestBody TesterIntegracyjny testerIntegracyjny) {
//        testerIntegracyjnyService.addNewTesterIntegracyjny(testerIntegracyjny);
//    }
//
//    @DeleteMapping(path = "{testerIntegracyjnyId}")
//    public void deleteTesterIntegracyjny (@PathVariable("testerIntegracyjnyId") Long testerIntegracyjnyID) {
//        testerIntegracyjnyService.deleteTesterIntegracyjny(testerIntegracyjnyID);
//    }
//
//    @PutMapping(path = "{testerIntegracyjnyId}")
//    public void updateTesterIntegracyjny(
//            @PathVariable("testerIntegracyjnyId") Long testerIntegracyjnyId,
//            @RequestParam(required = false) String imie) {
//        testerIntegracyjnyService.updateTesterIntegracyjny(testerIntegracyjnyId, imie);
//    }
}
