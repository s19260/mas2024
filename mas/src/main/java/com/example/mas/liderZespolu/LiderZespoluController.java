package com.example.mas.liderZespolu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/liderZespolu")
public class LiderZespoluController {

    private final com.example.mas.liderZespolu.LiderZespoluService liderZespoluService;

    @Autowired
    public LiderZespoluController(com.example.mas.liderZespolu.LiderZespoluService liderZespoluService) {
        this.liderZespoluService = liderZespoluService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LiderZespolu>> getAllLiderZespolu() {
        List<LiderZespolu> liderZespoluzy = liderZespoluService.getLiderZespolu();
        return new ResponseEntity<>(liderZespoluzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LiderZespolu> getLiderZespoluById(@PathVariable ("id") Long id) {
        LiderZespolu liderZespolu = liderZespoluService.getLiderZespolu().get(Math.toIntExact(id));
        return new ResponseEntity<>(liderZespolu, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<LiderZespolu> addLiderZespolu(@RequestBody LiderZespolu liderZespolu) {
        LiderZespolu nowyLiderZespolu = liderZespoluService.addNewLiderZespolu(liderZespolu);
        return new ResponseEntity<>(liderZespolu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LiderZespolu> updateLiderZespolu(@RequestBody LiderZespolu liderZespolu) {
        Optional<LiderZespolu> zaktualizujLiderZespolu = liderZespoluService.updateLiderZespolu(liderZespolu);
        return new ResponseEntity<>(liderZespolu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{liderZespoluId}")
    public ResponseEntity<?> deleteLiderZespolu(@PathVariable ("liderZespoluId") Long liderZespoluId) {
        liderZespoluService.deleteLiderZespolu(liderZespoluId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<LiderZespolu> getLiderZespolu() {
//        return liderZespoluService.getLiderZespolu();
//    }
//
//    @PostMapping
//    public void registerNewLiderZespolu (@RequestBody LiderZespolu liderZespolu) {
//        liderZespoluService.addNewLiderZespolu(liderZespolu);
//    }
//
//    @DeleteMapping(path = "{liderZespoluId}")
//    public void deleteLiderZespolu (@PathVariable("liderZespoluId") Long liderZespoluID) {
//        liderZespoluService.deleteLiderZespolu(liderZespoluID);
//    }
//
//    @PutMapping(path = "{liderZespoluId}")
//    public void updateLiderZespolu(
//            @PathVariable("liderZespoluId") Long liderZespoluId,
//            @RequestParam(required = false) String imie) {
//        liderZespoluService.updateLiderZespolu(liderZespoluId, imie);
//    }
}
