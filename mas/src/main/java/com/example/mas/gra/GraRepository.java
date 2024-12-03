package com.example.mas.gra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GraRepository
        extends JpaRepository<Gra, Long> {

 //   @Query("SELECT s FROM Gra s WHERE s.id = ?1")
    Optional<Gra> findGraById(Long id);

}
