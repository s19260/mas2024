package com.example.mas.pracownikStudia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/pracownikstudia")
public class PracownikStudiaController {


    private final PracownikStudiaService pracownikStudiaService;

    @Autowired
    public PracownikStudiaController(PracownikStudiaService pracownikStudiaService) {
        this.pracownikStudiaService = pracownikStudiaService;
    }

    @GetMapping
    public List<PracownikStudia> getPracownikStudia() {
        return pracownikStudiaService.getPracownikStudia();
    }

    @PostMapping
    public void registerNewPracownikStudia (@RequestBody PracownikStudia pracownikStudia) {
        pracownikStudiaService.addNewPracownikStudia(pracownikStudia);
    }

    @DeleteMapping(path = "{pracownikStudiaId}")
    public void deletePracownikStudia (@PathVariable("pracownikStudiaId") Long pracownikStudiaID) {
        pracownikStudiaService.deletePracownikStudia(pracownikStudiaID);
    }

    @PutMapping(path = "{pracownikStudiaId}")
    public void updatePracownikStudia(
            @PathVariable("pracownikStudiaId") Long pracownikStudiaId,
            @RequestParam(required = false) String imie) {
                pracownikStudiaService.updatePracownikStudia(pracownikStudiaId, imie);
    }
}
