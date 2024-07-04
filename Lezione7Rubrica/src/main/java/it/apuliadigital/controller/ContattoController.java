package it.apuliadigital.controller;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContattoController {

    @Autowired
    private ContattoService contattoService;

    // metodo per aggiungere un contatto
    @PostMapping("/contacts")
    ResponseEntity<?> addContact(@RequestBody ContattoEntity contatto) {
        return new ResponseEntity<>(contattoService.aggiungiContatto(contatto), HttpStatus.OK);
    }

    // metodo per ottenere un contatto
    @GetMapping("/contacts/{id}")
    ResponseEntity<?> getContact(@PathVariable String id) {
        return new ResponseEntity<>(contattoService.getContattoById(id), HttpStatus.OK);
    }

    // metodo per ottenere una lista di contatti
    @GetMapping("/contacts")
    ResponseEntity<?> getContacts() {
        return new ResponseEntity<>(contattoService.getContatti(), HttpStatus.OK);
    }

    // metodo per cercare un contatto per nome e/o cognome
    @GetMapping("/contacts/search")
    ResponseEntity<?> searchContacts(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "cognome", required = false) String cognome) {
        return new ResponseEntity<>(contattoService.searchContatti(nome, cognome), HttpStatus.OK);
    }

    // metodo per modificare un contatto
    @PutMapping("/contacts/{id}")
    ResponseEntity<?> updateContact(@PathVariable String id, @RequestBody ContattoEntity contatto) {
        contatto.setId(id);
        contattoService.aggiungiContatto(contatto);
        return ResponseEntity.ok("Contatto modificato correttamente 👍");
    }

    // metodo per eliminare un contatto
    @DeleteMapping("/contacts/{id}")
    ResponseEntity<?> deleteContact(@PathVariable String id) {
        contattoService.eliminaContatto(id);
        return ResponseEntity.ok("Contatto eliminato correttamente 👍");
    }

    // metodo per gestire le eccezioni
    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<?> handleException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
