package com.example.mas.testerJednostkowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/testerJednostkowy")
public class TesterJednostkowyController {

    private final com.example.mas.testerJednostkowy.TesterJednostkowyService testerJednostkowyService;

    @Autowired
    public TesterJednostkowyController(com.example.mas.testerJednostkowy.TesterJednostkowyService testerJednostkowyService) {
        this.testerJednostkowyService = testerJednostkowyService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TesterJednostkowy>> getAllTesterJednostkowy() {
        List<TesterJednostkowy> testerJednostkowyzy = testerJednostkowyService.getTesterJednostkowy();
        return new ResponseEntity<>(testerJednostkowyzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TesterJednostkowy> getTesterJednostkowyById(@PathVariable ("id") Long id) {
        TesterJednostkowy testerJednostkowy = testerJednostkowyService.getTesterJednostkowy().get(Math.toIntExact(id));
        return new ResponseEntity<>(testerJednostkowy, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TesterJednostkowy> addTesterJednostkowy(@RequestBody TesterJednostkowy testerJednostkowy) {
        TesterJednostkowy nowyTesterJednostkowy = testerJednostkowyService.addNewTesterJednostkowy(testerJednostkowy);
        return new ResponseEntity<>(testerJednostkowy, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TesterJednostkowy> updateTesterJednostkowy(@RequestBody TesterJednostkowy testerJednostkowy) {
        Optional<TesterJednostkowy> zaktualizujTesterJednostkowy = testerJednostkowyService.updateTesterJednostkowy(testerJednostkowy);
        return new ResponseEntity<>(testerJednostkowy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{testerJednostkowyId}")
    public ResponseEntity<?> deleteTesterJednostkowy(@PathVariable ("testerJednostkowyId") Long testerJednostkowyId) {
        testerJednostkowyService.deleteTesterJednostkowy(testerJednostkowyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<TesterJednostkowy> getTesterJednostkowy() {
//        return testerJednostkowyService.getTesterJednostkowy();
//    }
//
//    @PostMapping
//    public void registerNewTesterJednostkowy (@RequestBody TesterJednostkowy testerJednostkowy) {
//        testerJednostkowyService.addNewTesterJednostkowy(testerJednostkowy);
//    }
//
//    @DeleteMapping(path = "{testerJednostkowyId}")
//    public void deleteTesterJednostkowy (@PathVariable("testerJednostkowyId") Long testerJednostkowyID) {
//        testerJednostkowyService.deleteTesterJednostkowy(testerJednostkowyID);
//    }
//
//    @PutMapping(path = "{testerJednostkowyId}")
//    public void updateTesterJednostkowy(
//            @PathVariable("testerJednostkowyId") Long testerJednostkowyId,
//            @RequestParam(required = false) String imie) {
//        testerJednostkowyService.updateTesterJednostkowy(testerJednostkowyId, imie);
//    }
}
