package com.example.mas.testerJednostkowy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/testerJednostkowy")
public class TesterJednostkowyController {

    private final com.example.mas.testerJednostkowy.TesterJednostkowyService testerJednostkowyService;

    @Autowired
    public TesterJednostkowyController(com.example.mas.testerJednostkowy.TesterJednostkowyService testerJednostkowyService) {
        this.testerJednostkowyService = testerJednostkowyService;
    }

    @GetMapping
    public List<TesterJednostkowy> getTesterJednostkowy() {
        return testerJednostkowyService.getTesterJednostkowy();
    }
    @GetMapping(path = "/all")
    public List<TesterJednostkowyDTO> getTesterJednostkowyDTO() {
        return testerJednostkowyService.getTesterJednostkowyDTO();
    }

    @PostMapping
    public void registerNewTesterJednostkowy (@RequestBody TesterJednostkowy testerJednostkowy) {
        testerJednostkowyService.addNewTesterJednostkowy(testerJednostkowy);
    }

    @DeleteMapping(path = "{testerJednostkowyId}")
    public void deleteTesterJednostkowy (@PathVariable("testerJednostkowyId") Long testerJednostkowyID) {
        testerJednostkowyService.deleteTesterJednostkowy(testerJednostkowyID);
    }

    @PutMapping(path = "{testerJednostkowyId}")
    public void updateTesterJednostkowy(
            @PathVariable("testerJednostkowyId") Long testerJednostkowyId,
            @RequestParam(required = false) String imie) {
        testerJednostkowyService.updateTesterJednostkowy(testerJednostkowyId, imie);
    }
}
