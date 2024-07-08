package dev.buttazzopierluigi.battletohero.controller;

import dev.buttazzopierluigi.battletohero.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BattleController {

    // iniezione della classe service
    @Autowired
    private BattleService battleService;

    // controller per simulare una battaglia
    @GetMapping("/battle")
    ResponseEntity<?> startBattle(@RequestParam (value = "heroe1") int heroe1, @RequestParam (value = "heroe2") int heroe2, @RequestParam (value = "logic") double difficulty){
        return new ResponseEntity<>(battleService.startBattle(heroe1, heroe2, difficulty), org.springframework.http.HttpStatus.OK);
    }
}
