package com.example.mas.gra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/gra")
public class GraController {


    private final GraService graService;

    @Autowired
    public GraController(GraService graService) {
        this.graService = graService;
    }

    @GetMapping
    public List<GraDTO> getGraDTO() {
        return graService.getGra();
    }

    @GetMapping(path = "/getAllGryNull")
    public List<GraDTO> getAllGryNull() {
        return graService.getGryWhereProjektNull();
    }

    @PostMapping
    public void registerNewGra (@RequestBody Gra gra) {
        graService.addNewGra(gra);
    }

    @DeleteMapping(path = "{graId}")
    public void deleteGra (@PathVariable("graId") Long graID) {
        graService.deleteGra(graID);
    }

    @PutMapping(path = "{graId}")
    public void updateGra(
            @PathVariable("graId") Long graId,
            @RequestParam(required = false) String imie) {
        graService.updateGra(graId, imie);
    }
}
