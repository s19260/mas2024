package com.example.mas.deweloper;

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
    public void registerNewDeweloper (@RequestBody Deweloper deweloper) {
        deweloperService.addNewDeweloper(deweloper);
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
