package com.example.mas.projektGry;

import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import com.example.mas.pracownikStudia.PracownikStudiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/projektgry")
public class ProjektGryController {


    private final ProjektGryService projektGryService;


    @Autowired
    public ProjektGryController(ProjektGryService projektGryService) {
        this.projektGryService = projektGryService;
    }

    @GetMapping
    public ResponseEntity<List<ProjektGryDTO>> getAllProjektGry() {
        return ResponseEntity.ok(projektGryService.getAllProjektGry());
    }

    @GetMapping(path = "{projektGryId}")
    public ProjektGryDTO getProjektGry(
            @PathVariable("projektGryId") Long projektGryId
    ) {
        return projektGryService.getProjektGry(projektGryId);
    }

    @PostMapping(path = "/add-projekt-gry")
    public ProjektGryDoZapisuDTO addNewProjektGryDoZapisu (@RequestBody ProjektGryDoZapisuDTO projektGry) {
        return projektGryService.addNewProjektGryDoZapisu(projektGry);
    }

    @DeleteMapping(path = "{projektGryId}")
    public void deleteProjektGry (@PathVariable("projektGryId") Long projektGryID) {
        projektGryService.deleteProjektGry(projektGryID);
    }

    @PutMapping(path = "{projektGryId}")
    public void updateProjektGry(
            @PathVariable("projektGryId") Long projektGryId,
            @RequestParam("sprzet") String sprzet,
            @RequestParam("budzet") Long budzet,
            @RequestParam("kosztMarketingu") double kosztMarketingu,
            @RequestParam("kosztUtrzymania") double kosztUtrzymania,
            @RequestParam("liderZespoluId") Long liderZespoluID
            ) {
        projektGryService.updateProjektGry(projektGryId, sprzet, budzet, kosztMarketingu, kosztUtrzymania, liderZespoluID);
  }

    @PutMapping("/{projektGryId}/assign-to/{przedstawicielWydawcyId}")
    public ResponseEntity<ProjektGryDTO> assignProjektGryToPrzedstawiciel(
            @PathVariable Long projektGryId,
            @PathVariable Long przedstawicielWydawcyId) {
        ProjektGryDTO updatedProjektGry = projektGryService.assignProjektGry(przedstawicielWydawcyId, projektGryId);
        return ResponseEntity.ok(updatedProjektGry);
    }
}
