package it.apuliadigital.service.impl;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.repository.ContattoRepository;
import it.apuliadigital.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public String aggiungiContatto(ContattoEntity contatto) {
        contattoRepository.save(contatto);
        if (contatto.getId() == null) {
            throw new RuntimeException("Errore durante l'aggiunta del contatto");
        }
        return contatto.getId();
    }

    @Override
    public ContattoEntity getContattoById(String id) {
        if (contattoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Contatto non trovato");
        }
        return contattoRepository.findById(id).orElse(null);
    }

    @Override
    public List<ContattoEntity> getContatti() {
        return (List<ContattoEntity>) contattoRepository.findAll();
    }

    @Override
    public List<ContattoEntity> searchContatti(String nome, String cognome) {
        List<ContattoEntity> contatti = getContatti();
        if (contatti.isEmpty()) {
            throw new RuntimeException("Nessun contatto trovato");
        }

        if (nome != null && cognome != null) {
            return contatti.stream().filter(contatto -> contatto.getNome().equalsIgnoreCase(nome) && contatto.getCognome().equalsIgnoreCase(cognome)).toList();
        } else if (nome != null) {
            return contatti.stream().filter(contatto -> contatto.getNome().equalsIgnoreCase(nome)).toList();
        } else if (cognome != null) {
            return contatti.stream().filter(contatto -> contatto.getCognome().equalsIgnoreCase(cognome)).toList();
        } else {
            return contatti;
        }
    }

    @Override
    public void eliminaContatto(String id) {
        if (contattoRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Contatto non trovato");
        }
        contattoRepository.deleteById(id);
    }
}
