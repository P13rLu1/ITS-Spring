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
        try {
            contattoRepository.save(contatto);
            return contatto.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ContattoEntity getContattoById(String id) {
        try {
            return contattoRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ContattoEntity> getContatti() {
        return (List<ContattoEntity>) contattoRepository.findAll();
    }

    @Override
    public List<ContattoEntity> searchContatti(String nome, String cognome) {
        List<ContattoEntity> contatti = getContatti();
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
        try {
            contattoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
