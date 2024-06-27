package com.apiexample.lezione4api.service;

import com.apiexample.lezione4api.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    void addPersona(PersonaEntity persona); // funzione per aggiungere una persona

    List<PersonaEntity> getListaPersone(); // funzione per ottenere la lista di tutte le persone

    void deletePersona(int id); // funzione per eliminare una persona

    PersonaEntity getPersonaById(int id); // funzione per ottenere una persona dato il suo id
}
