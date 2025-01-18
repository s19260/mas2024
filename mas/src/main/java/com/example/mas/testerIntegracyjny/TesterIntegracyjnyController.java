package com.example.mas.testerIntegracyjny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/testerIntegracyjny")
public class TesterIntegracyjnyController {

    private final com.example.mas.testerIntegracyjny.TesterIntegracyjnyService testerIntegracyjnyService;

    @Autowired
    public TesterIntegracyjnyController(com.example.mas.testerIntegracyjny.TesterIntegracyjnyService testerIntegracyjnyService) {
        this.testerIntegracyjnyService = testerIntegracyjnyService;
    }

    @GetMapping
    public List<TesterIntegracyjny> getTesterIntegracyjny() {
        return testerIntegracyjnyService.getTesterIntegracyjny();
    }
    @GetMapping(path = "/all")
    public List<TesterIntegracyjnyDTO> getTesterIntegracyjnyDTO() {
        return testerIntegracyjnyService.getTesterIntegracyjnyDTO();
    }

    @PostMapping
    public void registerNewTesterIntegracyjny (@RequestBody TesterIntegracyjny testerIntegracyjny) {
        testerIntegracyjnyService.addNewTesterIntegracyjny(testerIntegracyjny);
    }

    @DeleteMapping(path = "{testerIntegracyjnyId}")
    public void deleteTesterIntegracyjny (@PathVariable("testerIntegracyjnyId") Long testerIntegracyjnyID) {
        testerIntegracyjnyService.deleteTesterIntegracyjny(testerIntegracyjnyID);
    }

    @PutMapping(path = "{testerIntegracyjnyId}")
    public void updateTesterIntegracyjny(
            @PathVariable("testerIntegracyjnyId") Long testerIntegracyjnyId,
            @RequestParam(required = false) String imie) {
        testerIntegracyjnyService.updateTesterIntegracyjny(testerIntegracyjnyId, imie);
    }
}
