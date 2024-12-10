package com.example.mas.tester;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/tester")
public class TesterController {

    private final com.example.mas.tester.TesterService testerService;

    @Autowired
    public TesterController(com.example.mas.tester.TesterService testerService) {
        this.testerService = testerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tester>> getAllTester() {
        List<Tester> testerzy = testerService.getTester();
        return new ResponseEntity<>(testerzy, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tester> getTesterById(@PathVariable ("id") Long id) {
        Tester tester = testerService.getTester().get(Math.toIntExact(id));
        return new ResponseEntity<>(tester, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tester> addTester(@RequestBody Tester tester) {
        Tester nowyTester = testerService.addNewTester(tester);
        return new ResponseEntity<>(tester, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tester> updateTester(@RequestBody Tester tester) {
        Optional<Tester> zaktualizujTester = testerService.updateTester(tester);
        return new ResponseEntity<>(tester, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{testerId}")
    public ResponseEntity<?> deleteTester(@PathVariable ("testerId") Long testerId) {
        testerService.deleteTester(testerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    //
//    @GetMapping
//    public List<Tester> getTester() {
//        return testerService.getTester();
//    }
//
//    @PostMapping
//    public void registerNewTester (@RequestBody Tester tester) {
//        testerService.addNewTester(tester);
//    }
//
//    @DeleteMapping(path = "{testerId}")
//    public void deleteTester (@PathVariable("testerId") Long testerID) {
//        testerService.deleteTester(testerID);
//    }
//
//    @PutMapping(path = "{testerId}")
//    public void updateTester(
//            @PathVariable("testerId") Long testerId,
//            @RequestParam(required = false) String imie) {
//        testerService.updateTester(testerId, imie);
//    }
}
