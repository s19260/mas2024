package com.example.mas.zlecenieProjektu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/zlecenieProjektu")
public class ZlecenieProjektuController {


    private final ZlecenieProjektuService zlecenieProjektuService;

    @Autowired
    public ZlecenieProjektuController(ZlecenieProjektuService zlecenieProjektuService) {
        this.zlecenieProjektuService = zlecenieProjektuService;
    }

    @GetMapping
    public List<ZlecenieProjektu> getZlecenieProjektu() {
        return zlecenieProjektuService.getZlecenieProjektu();
    }

    @PostMapping
    public void registerNewZlecenieProjektu(@RequestBody ZlecenieProjektu zlecenieProjektu) {
        zlecenieProjektuService.addNewZlecenieProjektu(zlecenieProjektu);
    }

    @DeleteMapping(path = "{zlecenieProjektuId}")
    public void deleteZlecenieProjektu (@PathVariable("zlecenieProjektuId") Long zlecenieProjektuID) {
        zlecenieProjektuService.deleteZlecenieProjektu(zlecenieProjektuID);
    }

    @PutMapping(path = "{zlecenieProjektuId}")
    public void updateZlecenieProjektu(
            @PathVariable("zlecenieProjektuId") Long zlecenieProjektuId,
            @RequestParam(required = false) String liderZespolu) {
        zlecenieProjektuService.updateZlecenieProjektu(zlecenieProjektuId, liderZespolu);
    }
}
