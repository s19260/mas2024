package com.example.mas.testerEndToEnd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/testerEndToEnd")
public class TesterEndToEndController {

    private final com.example.mas.testerEndToEnd.TesterEndToEndService testerEndToEndService;

    @Autowired
    public TesterEndToEndController(com.example.mas.testerEndToEnd.TesterEndToEndService testerEndToEndService) {
        this.testerEndToEndService = testerEndToEndService;
    }

    @GetMapping
    public List<TesterEndToEnd> getTesterEndToEnd() {
        return testerEndToEndService.getTesterEndToEnd();
    }
    @GetMapping(path = "/all")
    public List<TesterEndToEndDTO> getTesterEndToEndDTO() {
        return testerEndToEndService.getTesterEndToEndDTO();
    }

    @PostMapping("/add-tester-end-to-end")
    public TesterEndToEndDTO registerNewTesterEndToEnd (@RequestBody TesterEndToEndDTO testerEndToEnd) {
        return testerEndToEndService.addNewTesterEndToEnd(testerEndToEnd);
    }

    @DeleteMapping(path = "{testerEndToEndId}")
    public void deleteTesterEndToEnd (@PathVariable("testerEndToEndId") Long testerEndToEndID) {
        testerEndToEndService.deleteTesterEndToEnd(testerEndToEndID);
    }

    @PutMapping(path = "{testerEndToEndId}")
    public void updateTesterEndToEnd(
            @PathVariable("testerEndToEndId") Long testerEndToEndId,
            @RequestParam(required = false) String imie) {
        testerEndToEndService.updateTesterEndToEnd(testerEndToEndId, imie);
    }
}
