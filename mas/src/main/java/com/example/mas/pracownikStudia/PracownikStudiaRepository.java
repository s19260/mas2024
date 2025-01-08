package com.example.mas.pracownikStudia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PracownikStudiaRepository
        extends JpaRepository<PracownikStudia, Long> {

    @Query("SELECT s FROM PracownikStudia s WHERE s.id = ?1")
    Optional<PracownikStudia> findPracownikStudiaById(Long id);
}
