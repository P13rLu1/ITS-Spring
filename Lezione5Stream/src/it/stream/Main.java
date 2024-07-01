package it.stream;


import it.stream.entity.Impiegato;
import it.stream.service.impl.ImpiegatoServiceImpl;
import it.stream.service.impl.PersonaServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        PersonaServiceImpl personaService = new PersonaServiceImpl();
        ImpiegatoServiceImpl impiegatoService = new ImpiegatoServiceImpl();

        personaService.addPersona("Mario", "Rossi", 25);
        personaService.addPersona("Luca", "Bianchi", 17);
        personaService.addPersona("Paolo", "Verdi", 30);
        personaService.addPersona("Giuseppe", "Gialli", 15);
        personaService.addPersona("Giovanni", "Neri", 20);

        System.out.println("Persone:");
        personaService.printPersone();

        System.out.println("\nPersone maggiorenni:");
        personaService.printPersoneMaggiorenni();

        System.out.println("\nPersone minorenni:");
        personaService.printPersoneMinorenni();

        System.out.println("\nPersone con nome 'Mario':");
        personaService.printPersonePerNome("Mario");

        System.out.println("\nPersone con cognome 'Rossi':");
        personaService.printPersonePerCognome("Rossi");

        System.out.println("\nPersone con età 25:");
        personaService.printPersonePerEta(25);

        System.out.println("\nPersone con nome 'Mario' e cognome 'Rossi':");
        personaService.printPersonePerNomeECognome("Mario", "Rossi");

        personaService.removePersonaByNome("Mario");

        System.out.println("\nPersone dopo la rimozione di 'Mario':");
        personaService.printPersone();

        int numeroPersone = personaService.countPersone();
        System.out.println("\nNumero di persone: " + numeroPersone);

        System.out.println("\nSalvataggio su file:");
        personaService.savaToFile("persone.txt");

        impiegatoService.addImpiegato("Mario", "Rossi", 2500, 25);
        impiegatoService.addImpiegato("Luca", "Bianchi", 1700, 17);
        impiegatoService.addImpiegato("Paolo", "Verdi", 3000, 30);
        impiegatoService.addImpiegato("Giuseppe", "Gialli", 1500, 15);
        impiegatoService.addImpiegato("Giovanni", "Neri", 2000, 20);

        System.out.println("\nImpiegati filtrati per stipendio:");
        impiegatoService.filtrareImpiegatiPerStipendio(2500);

        System.out.println("\nImpiegati:");
        impiegatoService.printImpiegati();

        System.out.println("\nImpiegati:");
        List<Impiegato> impiegati = impiegatoService.getImpiegati();
        impiegati.forEach(System.out::println);

        long numeroImpiegati = impiegatoService.countImpiegati();
        System.out.println("\nNumero di impiegati: " + numeroImpiegati);

        long numeroImpiegatiPerEta = impiegatoService.countImpiegatiPerEta(25);
        System.out.println("\nNumero di impiegati con età 25: " + numeroImpiegatiPerEta);

        int maxEta = impiegati.stream()
                .mapToInt(Impiegato::getEta)
                .max()
                .orElseThrow();
        System.out.println("\nEtà massima: " + maxEta);

        System.out.println("\nImpiegati ordinati per cognome:");
        impiegati.stream()
                .sorted(Comparator.comparing(Impiegato::getCognome))
                .forEach(System.out::println);

        try {
            List<String> errori = Files.lines(Paths.get("errori.txt")).filter(l -> l.startsWith("ERROR")).limit(7).toList();
            errori.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}