package com.example.mas.gra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/gra")
public class GraController {

    private final com.example.mas.gra.GraService graService;

    @Autowired
    public GraController(com.example.mas.gra.GraService graService) {
        this.graService = graService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gra>> getAllGra() {
        List<Gra> grazy = graService.getGra();
        return new ResponseEntity<>(grazy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Gra> getGraById(@PathVariable ("id") Long id) {
        Gra gra = graService.getGra().get(Math.toIntExact(id));
        return new ResponseEntity<>(gra, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gra> addGra(@RequestBody Gra gra) {
        Gra nowaGra = graService.addNewGra(gra);
        return new ResponseEntity<>(gra, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Gra> updateGra(@RequestBody Gra gra) {
        Optional<Gra> zaktualizujGra = graService.updateGra(gra);
        return new ResponseEntity<>(gra, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{graId}")
    public ResponseEntity<?> deleteGra(@PathVariable ("graId") Long graId) {
        graService.deleteGra(graId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<Gra> getGra() {
//        return graService.getGra();
//    }
//
//    @PostMapping
//    public void registerNewGra (@RequestBody Gra gra) {
//        graService.addNewGra(gra);
//    }
//
//    @DeleteMapping(path = "{graId}")
//    public void deleteGra (@PathVariable("graId") Long graID) {
//        graService.deleteGra(graID);
//    }
//
//    @PutMapping(path = "{graId}")
//    public void updateGra(
//            @PathVariable("graId") Long graId,
//            @RequestParam(required = false) String imie) {
//        graService.updateGra(graId, imie);
//    }
}
