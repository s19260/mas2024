package com.example.mas.przedstawicielWydawcy;

import com.example.mas.projektGry.ProjektGry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class PrzedstawicielWydawcyService {

    private final PrzedstawicielWydawcyRepository przedstawicielWydawcyRepository;

    @Autowired
    PrzedstawicielWydawcyService (PrzedstawicielWydawcyRepository repo) {
        this.przedstawicielWydawcyRepository = repo;
    }

    public List<PrzedstawicielWydawcy> getAllPrzedstawicielWydawcy() {
        return przedstawicielWydawcyRepository.findAll();
    }

    public PrzedstawicielWydawcy getPrzedstawicielWydawcy(Long id) {
        return przedstawicielWydawcyRepository.findById(id).orElseThrow(() -> new RuntimeException("PrzedstawicielWydawcy not found"));
    }

    public Set<ProjektGry> getAllProjektGryByPrzedstawicielId(Long przedstawicielId) {
        return getPrzedstawicielWydawcy(przedstawicielId).getProjektyGier();
    }
}
