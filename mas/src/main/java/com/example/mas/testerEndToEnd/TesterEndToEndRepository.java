package com.example.mas.testerEndToEnd;

import com.example.mas.projektGry.ProjektGry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesterEndToEndRepository
        extends JpaRepository<com.example.mas.testerEndToEnd.TesterEndToEnd, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.testerEndToEnd.TesterEndToEnd> findTesterEndToEndById(Long id);


}