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
    public PracownikStudiaDTO getPracownikStudiaDTO(
            @PathVariable("pracownikStudiaId") Long pracownikStudiaId
    ) {
        return pracownikStudiaService.getPracownikStudia(pracownikStudiaId);
    }

    @GetMapping("/projekt-gry/{projektGryId}")
    public List<PracownikStudia> getPracownicyByProjektGry(@PathVariable Long projektGryId) {
        return pracownikStudiaService.findAllPracownikStudiaByProjektGryId(projektGryId);
    }

    @PostMapping
    public void registerNewPracownikStudiaDTO (@RequestBody PracownikStudia pracownikStudia) {
        pracownikStudiaService.addNewPracownikStudia(pracownikStudia);
    }

    @PostMapping(path = "/add-pracownik-studia")
    public PracownikStudiaDTO registerNewPracownikStudia (@RequestBody PracownikStudiaDoZapisuDTO pracownikStudia) {
        return pracownikStudiaService.addNewPracownikStudia(pracownikStudia);
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
