package com.example.mas.deweloper;

import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDoZapisuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/deweloper")
public class DeweloperController {

    private final com.example.mas.deweloper.DeweloperService deweloperService;

    @Autowired
    public DeweloperController(com.example.mas.deweloper.DeweloperService deweloperService) {
        this.deweloperService = deweloperService;
    }

    @GetMapping
    public List<Deweloper> getDeweloper() {
        return deweloperService.getDeweloper();
    }

    @PostMapping
    public void registerNewDeweloperDTO (@RequestBody Deweloper deweloper) {
        deweloperService.addNewDeweloper(deweloper);
    }

    @PostMapping(path = "/add-deweloper")
    public DeweloperDTO registerNewDeweloper (@RequestBody DeweloperDTO deweloper) {
        return deweloperService.addNewDeweloper(deweloper);
    }

    @DeleteMapping(path = "{deweloperId}")
    public void deleteDeweloper (@PathVariable("deweloperId") Long deweloperID) {
        deweloperService.deleteDeweloper(deweloperID);
    }

    @PutMapping(path = "{deweloperId}")
    public void updateDeweloper(
            @PathVariable("deweloperId") Long deweloperId,
            @RequestParam(required = false) String imie) {
        deweloperService.updateDeweloper(deweloperId, imie);
    }
}
