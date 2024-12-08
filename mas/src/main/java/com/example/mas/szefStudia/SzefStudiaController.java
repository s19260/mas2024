package com.example.mas.szefStudia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/szefStudia")
public class SzefStudiaController {

    private final com.example.mas.szefStudia.SzefStudiaService szefStudiaService;

    @Autowired
    public SzefStudiaController(com.example.mas.szefStudia.SzefStudiaService szefStudiaService) {
        this.szefStudiaService = szefStudiaService;
    }

    @GetMapping
    public List<SzefStudia> getSzefStudia() {
        return szefStudiaService.getSzefStudia();
    }

    @PostMapping
    public void registerNewSzefStudia (@RequestBody SzefStudia szefStudia) {
        szefStudiaService.addNewSzefStudia(szefStudia);
    }

    @DeleteMapping(path = "{szefStudiaId}")
    public void deleteSzefStudia (@PathVariable("szefStudiaId") Long szefStudiaID) {
        szefStudiaService.deleteSzefStudia(szefStudiaID);
    }

    @PutMapping(path = "{szefStudiaId}")
    public void updateSzefStudia(
            @PathVariable("szefStudiaId") Long szefStudiaId,
            @RequestParam(required = false) String imie) {
        szefStudiaService.updateSzefStudia(szefStudiaId, imie);
    }
}
