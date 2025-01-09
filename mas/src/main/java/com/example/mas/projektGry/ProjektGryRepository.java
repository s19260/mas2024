package com.example.mas.projektGry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjektGryRepository
        extends JpaRepository<ProjektGry, Long> {

    //   @Query("SELECT s FROM ProjektGry s WHERE s.id = ?1")
    Optional<ProjektGry> findProjektGryById(Long id);

    List<ProjektGry> findAllByLiderZespoluId(Long liderZespoluId);

}
