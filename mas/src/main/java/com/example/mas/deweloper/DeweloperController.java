package com.example.mas.deweloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/deweloper")
public class DeweloperController {

    private final com.example.mas.deweloper.DeweloperService deweloperService;

    @Autowired
    public DeweloperController(com.example.mas.deweloper.DeweloperService deweloperService) {
        this.deweloperService = deweloperService;
    }

        @GetMapping("/all")
    public ResponseEntity<List<Deweloper>> getAllDeweloper() {
        List<Deweloper> deweloperzy = deweloperService.getDeweloper();
        return new ResponseEntity<>(deweloperzy, HttpStatus.OK);
        }

    @GetMapping("/find/{id}")
    public ResponseEntity<Deweloper> getDeweloperById(@PathVariable ("id") Long id) {
        Deweloper deweloper = deweloperService.getDeweloper().get(Math.toIntExact(id));
        return new ResponseEntity<>(deweloper, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Deweloper> addDeweloper(@RequestBody Deweloper deweloper) {
        Deweloper nowyDeweloper = deweloperService.addNewDeweloper(deweloper);
        return new ResponseEntity<>(deweloper, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Deweloper> updateDeweloper(@RequestBody Deweloper deweloper) {
        Optional<Deweloper> zaktualizujDeweloper = deweloperService.updateDeweloper(deweloper);
        return new ResponseEntity<>(deweloper, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{deweloperId}")
    public ResponseEntity<?> deleteDeweloper(@PathVariable ("deweloperId") Long deweloperId) {
        deweloperService.deleteDeweloper(deweloperId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



        //
//    @GetMapping
//    public List<Deweloper> getDeweloper() {
//        return deweloperService.getDeweloper();
//    }
//
//    @PostMapping
//    public void registerNewDeweloper (@RequestBody Deweloper deweloper) {
//        deweloperService.addNewDeweloper(deweloper);
//    }
//
//    @DeleteMapping(path = "{deweloperId}")
//    public void deleteDeweloper (@PathVariable("deweloperId") Long deweloperID) {
//        deweloperService.deleteDeweloper(deweloperID);
//    }
//
//    @PutMapping(path = "{deweloperId}")
//    public void updateDeweloper(
//            @PathVariable("deweloperId") Long deweloperId,
//            @RequestParam(required = false) String imie) {
//        deweloperService.updateDeweloper(deweloperId, imie);
//    }
}
