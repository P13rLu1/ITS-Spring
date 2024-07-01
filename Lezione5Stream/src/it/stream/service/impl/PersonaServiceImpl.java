package it.stream.service.impl;

import it.stream.entity.Persona;
import it.stream.service.PersonaService;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PersonaServiceImpl implements PersonaService {

    List<Persona> persone = new ArrayList<>();

    public void addPersona(String nome, String cognome, int eta) {
        Persona p = new Persona(nome, cognome, eta);
        persone.add(p);
    }

    public void removePersonaByNome(String nome) {
        persone.stream()
                .filter(p -> p.getNome().equals(nome))
                .findFirst()
                .ifPresent(p -> persone.remove(p));
    }

    public void printPersone() {
        persone.forEach(System.out::println);
    }

    public void printPersoneMaggiorenni() {
        persone.stream()
                .filter(p -> p.getEta() >= 18)
                .forEach(System.out::println);
    }

    public void printPersoneMinorenni() {
        persone.stream()
                .filter(p -> p.getEta() < 18)
                .forEach(System.out::println);
    }

    public void printPersonePerNome(String nome) {
        persone.stream()
                .filter(p -> p.getNome().equals(nome))
                .forEach(System.out::println);
    }

    public void printPersonePerCognome(String cognome) {
        persone.stream()
                .filter(p -> p.getCognome().equals(cognome))
                .forEach(System.out::println);
    }

    public void printPersonePerEta(int eta) {
        persone.stream()
                .filter(p -> p.getEta() == eta)
                .forEach(System.out::println);
    }

    public void printPersonePerNomeECognome(String nome, String cognome) {
        persone.stream()
                .filter(p -> p.getNome().equals(nome) && p.getCognome().equals(cognome))
                .forEach(System.out::println);
    }

    public int countPersone() {
        return persone.stream().mapToInt(p -> 1).sum();
    }

    public void savaToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Persona p : persone) {
                writer.println(p);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
