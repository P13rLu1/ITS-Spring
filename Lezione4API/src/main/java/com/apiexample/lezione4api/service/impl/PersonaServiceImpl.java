package com.apiexample.lezione4api.service.impl;

import com.apiexample.lezione4api.entity.PersonaEntity;
import com.apiexample.lezione4api.entity.repository.PersonaRepository;
import com.apiexample.lezione4api.service.PersonaService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.apiexample.lezione4api.utils.Constants.FILE_NAME;
import static com.apiexample.lezione4api.utils.Constants.OBJECT_MAPPER;

@Service
public class PersonaServiceImpl implements PersonaService {


    @Autowired
    private PersonaRepository personaRepository;

    // metodo che prenda la persona e lo mette in una lista che poi andrá messa in un file json
    @Override
    public void addPersona(PersonaEntity persona) {
        List<PersonaEntity> persone = getListaPersone();
        persone.add(persona);
        try {
            writePersona(persone);
        } catch (IOException e) {
            throw new RuntimeException("Errore nella scrittura del file");
        }
    }

    @Override
    public PersonaEntity addPersonaDB(PersonaEntity persona) {
        try {
            return personaRepository.save(persona);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'aggiunta della persona");
        }
    }

    // metodo per scrivere la lista di persone in un file json
    private void writePersona(List<PersonaEntity> persone) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(gson.toJson(persone));
        }
    }

    // metodo per leggere il file json e ritornare la lista di persone
    @Override
    public List<PersonaEntity> getListaPersone() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                return OBJECT_MAPPER.readValue(reader, new TypeReference<>() {
                });
            } catch (IOException e) {
                throw new RuntimeException("Errore nella lettura del file");
            }
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<PersonaEntity> getListaPersoneDB() {
        return personaRepository.findAll();
    }

    // metodo per eliminare una persona dalla lista
    @Override
    public void deletePersona(int id) {
        List<PersonaEntity> persone = getListaPersone();
        if (id > 0 && (id - 1) < persone.size()) {
            persone.remove(id - 1);
            try {
                writePersona(persone);
            } catch (IOException e) {
                throw new RuntimeException("Errore nella scrittura del file");
            }
        } else {
            throw new RuntimeException("Index fuori dai limiti");
        }
    }

    @Override
    public void deletePersonaDB(int id) {
        try {
            personaRepository.deleteById((long) id);
        } catch (Exception e) {
            throw new RuntimeException("Errore nell'eliminazione della persona");
        }
    }

    // metodo per ritornare una persona dalla lista
    @Override
    public PersonaEntity getPersonaById(int id) {
        List<PersonaEntity> persone = getListaPersone();
        if (id > 0 && (id - 1) < persone.size()) {
            return persone.get(id - 1);
        } else {
            throw new RuntimeException("Index fuori dai limiti");
        }
    }

    @Override
    public PersonaEntity getPersonaByIdDB(int id) {
        try {
            return personaRepository.findById((long) id).orElse(null);//findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Errore nel recupero della persona");
        }
    }
}
