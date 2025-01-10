package com.example.mas.pracownikStudia;

import com.example.mas.projektGry.ProjektGryDTO;
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
    public List<PracownikStudiaDTO> getPracownikStudia() {
        return pracownikStudiaService.getAllPracownikStudia();
    }

    @GetMapping(path = "{pracownikStudiaId}")
    public PracownikStudiaDTO getPracownikStudia(
            @PathVariable("pracownikStudiaId") Long pracownikStudiaId
    ) {
        return pracownikStudiaService.getPracownikStudia(pracownikStudiaId);
    }

    @PostMapping
    public void registerNewPracownikStudia (@RequestBody PracownikStudia pracownikStudia) {
        pracownikStudiaService.addNewPracownikStudia(pracownikStudia);
    }

    @PostMapping(path = "/add-pracownik-studia")
    public String registerNewPracownikStudia (@RequestBody PracownikStudiaDoZapisuDTO pracownikStudia) {
        pracownikStudiaService.addNewPracownikStudia(pracownikStudia);
        return "Super zapisany!!!";
    }


    @DeleteMapping(path = "{pracownikStudiaId}")
    public void deletePracownikStudia (@PathVariable("pracownikStudiaId") Long pracownikStudiaID) {
        pracownikStudiaService.deletePracownikStudia(pracownikStudiaID);
    }


    @PutMapping(path = "{pracownikStudiaId}")
    public void updatePracownikStudia(
            @PathVariable("pracownikStudiaId") Long pracownikStudiaId,
            @RequestParam("imie") String imie,
            @RequestParam("nazwisko") String nazwisko) {
                pracownikStudiaService.updatePracownikStudia(pracownikStudiaId, imie, nazwisko);
    }
}
