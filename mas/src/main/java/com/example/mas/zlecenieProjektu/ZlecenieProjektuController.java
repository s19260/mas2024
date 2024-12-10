package com.example.mas.zlecenieProjektu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/zlecenieProjektu")
public class ZlecenieProjektuController {

    private final com.example.mas.zlecenieProjektu.ZlecenieProjektuService zlecenieProjektuService;

    @Autowired
    public ZlecenieProjektuController(com.example.mas.zlecenieProjektu.ZlecenieProjektuService zlecenieProjektuService) {
        this.zlecenieProjektuService = zlecenieProjektuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ZlecenieProjektu>> getAllZlecenieProjektu() {
        List<ZlecenieProjektu> zlecenieProjektuzy = zlecenieProjektuService.getZlecenieProjektu();
        return new ResponseEntity<>(zlecenieProjektuzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ZlecenieProjektu> getZlecenieProjektuById(@PathVariable ("id") Long id) {
        ZlecenieProjektu zlecenieProjektu = zlecenieProjektuService.getZlecenieProjektu().get(Math.toIntExact(id));
        return new ResponseEntity<>(zlecenieProjektu, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ZlecenieProjektu> addZlecenieProjektu(@RequestBody ZlecenieProjektu zlecenieProjektu) {
        ZlecenieProjektu nowyZlecenieProjektu = zlecenieProjektuService.addNewZlecenieProjektu(zlecenieProjektu);
        return new ResponseEntity<>(zlecenieProjektu, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ZlecenieProjektu> updateZlecenieProjektu(@RequestBody ZlecenieProjektu zlecenieProjektu) {
        Optional<ZlecenieProjektu> zaktualizujZlecenieProjektu = zlecenieProjektuService.updateZlecenieProjektu(zlecenieProjektu);
        return new ResponseEntity<>(zlecenieProjektu, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{zlecenieProjektuId}")
    public ResponseEntity<?> deleteZlecenieProjektu(@PathVariable ("zlecenieProjektuId") Long zlecenieProjektuId) {
        zlecenieProjektuService.deleteZlecenieProjektu(zlecenieProjektuId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<ZlecenieProjektu> getZlecenieProjektu() {
//        return zlecenieProjektuService.getZlecenieProjektu();
//    }
//
//    @PostMapping
//    public void registerNewZlecenieProjektu (@RequestBody ZlecenieProjektu zlecenieProjektu) {
//        zlecenieProjektuService.addNewZlecenieProjektu(zlecenieProjektu);
//    }
//
//    @DeleteMapping(path = "{zlecenieProjektuId}")
//    public void deleteZlecenieProjektu (@PathVariable("zlecenieProjektuId") Long zlecenieProjektuID) {
//        zlecenieProjektuService.deleteZlecenieProjektu(zlecenieProjektuID);
//    }
//
//    @PutMapping(path = "{zlecenieProjektuId}")
//    public void updateZlecenieProjektu(
//            @PathVariable("zlecenieProjektuId") Long zlecenieProjektuId,
//            @RequestParam(required = false) String imie) {
//        zlecenieProjektuService.updateZlecenieProjektu(zlecenieProjektuId, imie);
//    }
}
