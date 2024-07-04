package it.apuliadigital.service.impl;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.exception.ContattoException;
import it.apuliadigital.repository.ContattoRepository;
import it.apuliadigital.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContattoServiceImpl implements ContattoService {

    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public String aggiungiContatto(ContattoEntity contatto) {
        contattoRepository.save(contatto);
        return contatto.getId();
    }

    @Override
    public ContattoEntity getContattoById(String id) {
        ContattoEntity contatto = contattoRepository.findById(id).orElse(null);
        if (contatto == null) {
            throw new ContattoException("Contatto non trovato");
        } else {
            return contatto;
        }
    }

    @Override
    public List<ContattoEntity> getContatti() {
        List<ContattoEntity> contatti = (List<ContattoEntity>) contattoRepository.findAll();
        if (contatti.isEmpty()) {
            throw new ContattoException("Nessun contatto trovato");
        } else {
            return contatti;
        }
    }

    @Override
    public List<ContattoEntity> searchContatti(String nome, String cognome) {
        List<ContattoEntity> contatti = getContatti();
        if (contatti.isEmpty()) {
            throw new ContattoException("Nessun contatto trovato");
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
        Optional<ContattoEntity> contatto = contattoRepository.findById(id);

        if (contatto.isPresent()) {
            contattoRepository.deleteById(id);
        } else {
            throw new ContattoException("Contatto non trovato");
        }
    }
}
