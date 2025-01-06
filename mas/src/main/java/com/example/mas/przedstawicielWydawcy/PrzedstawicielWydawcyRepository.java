package com.example.mas.przedstawicielWydawcy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzedstawicielWydawcyRepository extends JpaRepository<PrzedstawicielWydawcy, Long> {
    PrzedstawicielWydawcy findPrzedstawicielWydawcyById(Long id);
}
