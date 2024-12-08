package com.example.mas.testerJednostkowy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesterJednostkowyRepository
        extends JpaRepository<com.example.mas.testerJednostkowy.TesterJednostkowy, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.testerJednostkowy.TesterJednostkowy> findTesterJednostkowyById(Long id);

}