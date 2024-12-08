package com.example.mas.szefStudia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SzefStudiaRepository
        extends JpaRepository<com.example.mas.szefStudia.SzefStudia, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.szefStudia.SzefStudia> findSzefStudiaById(Long id);

}