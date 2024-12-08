package com.example.mas.testerIntegracyjny;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesterIntegracyjnyRepository
        extends JpaRepository<com.example.mas.testerIntegracyjny.TesterIntegracyjny, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.testerIntegracyjny.TesterIntegracyjny> findTesterIntegracyjnyById(Long id);

}