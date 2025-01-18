package com.example.mas.tester;

import com.example.mas.projektGry.ProjektGry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TesterRepository
        extends JpaRepository<com.example.mas.tester.Tester, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<com.example.mas.tester.Tester> findTesterById(Long id);


}