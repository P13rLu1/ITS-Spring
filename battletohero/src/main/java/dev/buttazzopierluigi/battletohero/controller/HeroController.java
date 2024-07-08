package dev.buttazzopierluigi.battletohero.controller;

import dev.buttazzopierluigi.battletohero.entity.HeroEntity;
import dev.buttazzopierluigi.battletohero.exception.ErrorResponse;
import dev.buttazzopierluigi.battletohero.exception.HeroException;
import dev.buttazzopierluigi.battletohero.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    // controller per aggiungere un eroe
    @PostMapping("/heroes")
    ResponseEntity<?> addHero(@RequestBody HeroEntity hero) {
        int id = heroService.addHero(hero);
        if (id != 0) {
            return new ResponseEntity<>("id: " +id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Errore durante l'aggiunta dell'eroe", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // controller per ottenere tutti gli eroi
    @GetMapping("/heroes")
    ResponseEntity<?> getHeroes() {
        return new ResponseEntity<>(heroService.getHeroes(), HttpStatus.OK);
    }

    // controller per ottenere un eroe per id
    @GetMapping("/heroes/{id}")
    ResponseEntity<?> getHeroById(@PathVariable int id) {
        return new ResponseEntity<>(heroService.getHeroById(id), HttpStatus.OK);
    }

    // controller per aggiornare un eroe per id
    @PutMapping("/heroes/{id}")
    ResponseEntity<?> updateHero(@PathVariable int id, @RequestBody HeroEntity hero) {
        heroService.updateHero(hero, id);
        return new ResponseEntity<>("Eroe modificato correttamente 👍", HttpStatus.OK);
    }

    // controller per eliminare un eroe per id
    @DeleteMapping("/heroes/{id}")
    ResponseEntity<?> deleteHero(@PathVariable int id) {
        heroService.deleteHero(id);
        return new ResponseEntity<>("Eroe eliminato correttamente 👍", HttpStatus.OK);
    }


    @ExceptionHandler(value = HeroException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleContactsNotFound(HeroException e) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}
