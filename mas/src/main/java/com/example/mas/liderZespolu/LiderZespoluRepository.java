package com.example.mas.liderZespolu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LiderZespoluRepository
        extends JpaRepository<com.example.mas.liderZespolu.LiderZespolu, Long> {

    @Query("SELECT s FROM LiderZespolu s WHERE s.id = ?1")
    Optional<com.example.mas.liderZespolu.LiderZespolu> findLiderZespoluById(Long id);

}