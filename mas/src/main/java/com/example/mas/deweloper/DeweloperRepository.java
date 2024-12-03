package com.example.mas.deweloper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeweloperRepository
        extends JpaRepository<com.example.mas.deweloper.Deweloper, Long> {

    @Query("SELECT s FROM Deweloper s WHERE s.id = ?1")
    Optional<com.example.mas.deweloper.Deweloper> findDeweloperById(Long id);

}