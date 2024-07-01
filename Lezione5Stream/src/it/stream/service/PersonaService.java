package it.stream.service;

public interface PersonaService {

    void addPersona(String nome, String cognome, int eta);

    void removePersonaByNome(String nome);

    void printPersone();

    void printPersoneMaggiorenni();

    void printPersoneMinorenni();

    void printPersonePerNome(String nome);

    void printPersonePerCognome(String cognome);

    void printPersonePerEta(int eta);

    void printPersonePerNomeECognome(String nome, String cognome);
}
