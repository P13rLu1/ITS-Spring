package it.apuliadigital.controller;

import it.apuliadigital.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/getRomano")
    ResponseEntity<?> getRomano(@RequestParam(value = "numero") int numero){
        try {
            return new ResponseEntity<>(logService.getRomano(numero), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDecimaleRomano")
    ResponseEntity<?> getDecimale(@RequestParam(value = "romano") String romano){
        try {
            return new ResponseEntity<>(logService.getDecimaleRomano(romano), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getBinario")
    ResponseEntity<?> getBinario(@RequestParam(value = "numero") int numero){
        try {
            return new ResponseEntity<>(logService.getBinario(numero), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDecimaleBinario")
    ResponseEntity<?> getDecimaleBinario(@RequestParam(value = "binario") String binario){
        try {
            return new ResponseEntity<>(logService.getDecimaleBinario(binario), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getEsadecimale")
    ResponseEntity<?> getEsadecimale(@RequestParam(value = "numero") int numero){
        try {
            return new ResponseEntity<>(logService.getEsadecimale(numero), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDecimaleEsadecimale")
    ResponseEntity<?> getDecimaleEsadecimale(@RequestParam(value = "esadecimale") String esadecimale){
        try {
            return new ResponseEntity<>(logService.getDecimaleEsadecimale(esadecimale), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
