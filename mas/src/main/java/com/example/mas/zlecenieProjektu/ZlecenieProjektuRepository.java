package com.example.mas.zlecenieProjektu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZlecenieProjektuRepository
        extends JpaRepository<ZlecenieProjektu, Long> {

   // @Query("SELECT s FROM ZlecenieProjektu s WHERE s.id = ?1")
    Optional<ZlecenieProjektu> findZlecenieProjektuById(Long id);

}
