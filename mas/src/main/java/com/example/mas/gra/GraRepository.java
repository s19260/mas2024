package com.example.mas.gra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GraRepository
        extends JpaRepository<Gra, Long> {

 //   @Query("SELECT s FROM Gra s WHERE s.id = ?1")
    Optional<Gra> findGraById(Long id);

    @Query("SELECT s FROM Gra s WHERE s.projektGry.id =?1")
    Optional<Gra> findGraByProjektGryId(Long id);

    @Query("SELECT g FROM Gra g LEFT JOIN ProjektGry pg ON g.id = pg.gra.id WHERE pg.gra.id IS NULL")
    List<Gra> findAllGraWhereProjektGryIsNull();

}
