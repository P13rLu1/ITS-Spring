package com.apiexample.lezione4api.controller;

import com.apiexample.lezione4api.entity.PersonaEntity;
import com.apiexample.lezione4api.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    // metodo per aggiungere una persona
    @PostMapping("/add")
    ResponseEntity<?> addPersona(@RequestBody PersonaEntity persona) {
        // chiamata al servizio per aggiungere una persona
        try {
            personaService.addPersona(persona);
            return new ResponseEntity<>(personaService.addPersonaDB(persona), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // metodo per ottenere la lista di tutte le persone
    @GetMapping("/get")
    ResponseEntity<?> getLista() {

        try {
            return new ResponseEntity<>(personaService.getListaPersoneDB(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    // metodo per eliminare una persona
    @DeleteMapping("/delete")
    ResponseEntity<?> deletePersona(@RequestParam(value = "id") int id) {
        try {
            personaService.deletePersona(id);
            personaService.deletePersonaDB(id);
            return ResponseEntity.ok("Persona eliminata correttamente");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // metodo per ritornare una persona
    @GetMapping("/getPersona")
    ResponseEntity<?> getPersona(@RequestParam(value = "id") int id) {
        try {
            return new ResponseEntity<>(personaService.getPersonaByIdDB(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
