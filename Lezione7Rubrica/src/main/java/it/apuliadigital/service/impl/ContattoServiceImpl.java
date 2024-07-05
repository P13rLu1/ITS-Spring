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
        if (nome != null && cognome != null) {
            return contattoRepository.searchByNomeAndCognome(nome, cognome);
        } else if (nome != null) {
            return contattoRepository.searchByNome(nome);
        } else if (cognome != null) {
            return contattoRepository.searchByCognome(cognome);
        } else {
            return getContatti();
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
