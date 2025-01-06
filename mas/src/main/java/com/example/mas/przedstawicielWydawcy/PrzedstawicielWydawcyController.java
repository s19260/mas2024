package com.example.mas.przedstawicielWydawcy;

import com.example.mas.projektGry.ProjektGry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1/przedstawicielwydawcy")
public class PrzedstawicielWydawcyController {

    PrzedstawicielWydawcyService przedstawicielWydawcyService;

    @Autowired
    PrzedstawicielWydawcyController (PrzedstawicielWydawcyService service) {
        przedstawicielWydawcyService = service;
    }

    @GetMapping()
    public List<PrzedstawicielWydawcy> getAllPrzedstawicielWydawcy() {
        return przedstawicielWydawcyService.getAllPrzedstawicielWydawcy();
    }

    @GetMapping("{przedstawicielWydawcyId}")
    public PrzedstawicielWydawcy getPrzedstawicielWydawcy(
            @PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyId) {
        return przedstawicielWydawcyService.getPrzedstawicielWydawcy(przedstawicielWydawcyId);
    }

    @GetMapping("{przedstawicielWydawcyId}/projektygry")
    public Set<ProjektGry> getAllProjektGryByPrzedstawicielWydawcyId(
            @PathVariable("przedstawicielWydawcyId") Long przedstawicielWydawcyId) {
        return przedstawicielWydawcyService.getAllProjektGryByPrzedstawicielId(przedstawicielWydawcyId);
    }

}
