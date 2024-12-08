package com.example.mas.przedstawicielWydawcy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/przedstawicielWydawcy")
public class PrzedstawicielWydawcyController {

    private final com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyService przedstawicielWydawcyService;

    @Autowired
    public PrzedstawicielWydawcyController(com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcyService przedstawicielWydawcyService) {
        this.przedstawicielWydawcyService = przedstawicielWydawcyService;
    }

    @GetMapping
    public List<PrzedstawicielWydawcy> getPrzedstawicielWydawcy() {
        return przedstawicielWydawcyService.getPrzedstawicielWydawcy();
    }

    @PostMapping
    public void registerNewPrzedstawicielWydawcy (@RequestBody PrzedstawicielWydawcy przedstawicielWydawcy) {
        przedstawicielWydawcyService.addNewPrzedstawicielWydawcy(przedstawicielWydawcy);
    }

    @DeleteMapping(path = "{przedstawicielWydawcyId}")
    public void deletePrzedstawicielWydawcy (@PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyID) {
        przedstawicielWydawcyService.deletePrzedstawicielWydawcy(przedstawicielWydawcyID);
    }

    @PutMapping(path = "{przedstawicielWydawcyId}")
    public void updatePrzedstawicielWydawcy(
            @PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyId,
            @RequestParam(required = false) String imie) {
        przedstawicielWydawcyService.updatePrzedstawicielWydawcy(przedstawicielWydawcyId, imie);
    }
}
