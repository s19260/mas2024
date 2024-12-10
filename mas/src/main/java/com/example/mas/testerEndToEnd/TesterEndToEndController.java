package com.example.mas.testerEndToEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/testerEndToEnd")
public class TesterEndToEndController {

    private final com.example.mas.testerEndToEnd.TesterEndToEndService testerEndToEndService;

    @Autowired
    public TesterEndToEndController(com.example.mas.testerEndToEnd.TesterEndToEndService testerEndToEndService) {
        this.testerEndToEndService = testerEndToEndService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TesterEndToEnd>> getAllTesterEndToEnd() {
        List<TesterEndToEnd> testerEndToEndzy = testerEndToEndService.getTesterEndToEnd();
        return new ResponseEntity<>(testerEndToEndzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TesterEndToEnd> getTesterEndToEndById(@PathVariable ("id") Long id) {
        TesterEndToEnd testerEndToEnd = testerEndToEndService.getTesterEndToEnd().get(Math.toIntExact(id));
        return new ResponseEntity<>(testerEndToEnd, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TesterEndToEnd> addTesterEndToEnd(@RequestBody TesterEndToEnd testerEndToEnd) {
        TesterEndToEnd nowyTesterEndToEnd = testerEndToEndService.addNewTesterEndToEnd(testerEndToEnd);
        return new ResponseEntity<>(testerEndToEnd, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<TesterEndToEnd> updateTesterEndToEnd(@RequestBody TesterEndToEnd testerEndToEnd) {
        Optional<TesterEndToEnd> zaktualizujTesterEndToEnd = testerEndToEndService.updateTesterEndToEnd(testerEndToEnd);
        return new ResponseEntity<>(testerEndToEnd, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{testerEndToEndId}")
    public ResponseEntity<?> deleteTesterEndToEnd(@PathVariable ("testerEndToEndId") Long testerEndToEndId) {
        testerEndToEndService.deleteTesterEndToEnd(testerEndToEndId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<TesterEndToEnd> getTesterEndToEnd() {
//        return testerEndToEndService.getTesterEndToEnd();
//    }
//
//    @PostMapping
//    public void registerNewTesterEndToEnd (@RequestBody TesterEndToEnd testerEndToEnd) {
//        testerEndToEndService.addNewTesterEndToEnd(testerEndToEnd);
//    }
//
//    @DeleteMapping(path = "{testerEndToEndId}")
//    public void deleteTesterEndToEnd (@PathVariable("testerEndToEndId") Long testerEndToEndID) {
//        testerEndToEndService.deleteTesterEndToEnd(testerEndToEndID);
//    }
//
//    @PutMapping(path = "{testerEndToEndId}")
//    public void updateTesterEndToEnd(
//            @PathVariable("testerEndToEndId") Long testerEndToEndId,
//            @RequestParam(required = false) String imie) {
//        testerEndToEndService.updateTesterEndToEnd(testerEndToEndId, imie);
//    }
}
