package it.apuliadigital.service;

import it.apuliadigital.entity.ContattoEntity;

import java.util.List;

public interface ContattoService {

    String aggiungiContatto(ContattoEntity contatto);

    ContattoEntity getContattoById(String id);

    List<ContattoEntity> getContatti();

    List<ContattoEntity> searchContatti(String name, String surname);

    void eliminaContatto(String id);
}
