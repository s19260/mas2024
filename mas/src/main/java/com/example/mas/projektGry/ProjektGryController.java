package com.example.mas.projektGry;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ProjektGry> getProjektGry() {
        return projektGryService.getProjektGry();
    }

    @PostMapping
    public void registerNewProjektGry (@RequestBody ProjektGry projektGry) {
        projektGryService.addNewProjektGry(projektGry);
    }

    @DeleteMapping(path = "{projektGryId}")
    public void deleteProjektGry (@PathVariable("projektGryId") Long projektGryID) {
        projektGryService.deleteProjektGry(projektGryID);
    }

    @PutMapping(path = "{projektGryId}")
    public void updateProjektGry(
            @PathVariable("projektGryId") Long projektGryId,
            @RequestParam(required = false) String liderZespolu) {
        projektGryService.updateProjektGry(projektGryId, liderZespolu);
  }
}
