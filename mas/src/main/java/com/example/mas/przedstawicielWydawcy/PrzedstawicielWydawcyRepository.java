package com.example.mas.przedstawicielWydawcy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrzedstawicielWydawcyRepository
        extends JpaRepository<com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.przedstawicielWydawcy.PrzedstawicielWydawcy> findPrzedstawicielWydawcyById(Long id);

}