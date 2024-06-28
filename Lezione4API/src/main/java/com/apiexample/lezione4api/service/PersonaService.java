package com.apiexample.lezione4api.service;

import com.apiexample.lezione4api.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    void addPersona(PersonaEntity persona);// funzione per aggiungere una persona

    PersonaEntity addPersonaDB(PersonaEntity persona); // funzione per aggiungere una persona nel database

    List<PersonaEntity> getListaPersone(); // funzione per ottenere la lista di tutte le persone

    List<PersonaEntity> getListaPersoneDB(); // funzione per ottenere la lista di tutte le persone dal database

    void deletePersona(int id);// funzione per eliminare una persona

    void deletePersonaDB(int id); // funzione per eliminare una persona dal database

    PersonaEntity getPersonaById(int id); // funzione per ottenere una persona dato il suo id

    PersonaEntity getPersonaByIdDB(int id); // funzione per ottenere una persona dato il suo id dal database
}
