package com.example.mas.tester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tester")
public class TesterController {

    private final com.example.mas.tester.TesterService testerService;

    @Autowired
    public TesterController(com.example.mas.tester.TesterService testerService) {
        this.testerService = testerService;
    }

    @GetMapping
    public List<Tester> getTester() {
        return testerService.getTester();
    }

    @PostMapping
    public void registerNewTester (@RequestBody Tester tester) {
        testerService.addNewTester(tester);
    }

    @DeleteMapping(path = "{testerId}")
    public void deleteTester (@PathVariable("testerId") Long testerID) {
        testerService.deleteTester(testerID);
    }

    @PutMapping(path = "{testerId}")
    public void updateTester(
            @PathVariable("testerId") Long testerId,
            @RequestParam(required = false) String imie) {
        testerService.updateTester(testerId, imie);
    }
}
