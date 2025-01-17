package com.example.mas.liderZespolu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/liderZespolu")
public class LiderZespoluController {

    private final com.example.mas.liderZespolu.LiderZespoluService liderZespoluService;

    @Autowired
    public LiderZespoluController(com.example.mas.liderZespolu.LiderZespoluService liderZespoluService) {
        this.liderZespoluService = liderZespoluService;
    }

    @GetMapping
    public List<LiderZespolu> getLiderZespolu() {
        return liderZespoluService.getLiderZespolu();
    }
    @GetMapping(path = "/all")
    public List<LiderZespoluDTO> getLiderZespoluDTO() {
        return liderZespoluService.getLiderZespoluDTO();
    }

    @PostMapping
    public void registerNewLiderZespolu (@RequestBody LiderZespolu liderZespolu) {
        liderZespoluService.addNewLiderZespolu(liderZespolu);
    }

    @DeleteMapping(path = "{liderZespoluId}")
    public void deleteLiderZespolu (@PathVariable("liderZespoluId") Long liderZespoluID) {
        liderZespoluService.deleteLiderZespolu(liderZespoluID);
    }

    @PutMapping(path = "{liderZespoluId}")
    public void updateLiderZespolu(
            @PathVariable("liderZespoluId") Long liderZespoluId,
            @RequestParam(required = false) String imie) {
        liderZespoluService.updateLiderZespolu(liderZespoluId, imie);
    }
}
