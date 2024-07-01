package it.stream.service.impl;

import it.stream.entity.Impiegato;

import java.util.ArrayList;
import java.util.List;

public class ImpiegatoServiceImpl {

    List<Impiegato> impiegati = new ArrayList<>();

    public void addImpiegato(String nome, String cognome, float stipendio, int eta) {
        Impiegato i = new Impiegato(nome, cognome, stipendio, eta);
        impiegati.add(i);
    }

    public void filtrareImpiegatiPerStipendio(float stipendio) {
        impiegati.stream()
                .filter(i -> i.getStipendio() == stipendio)
                .map(e -> e.getNome() + " " + e.getCognome())
                .forEach(System.out::println);
    }

    public void printImpiegati() {
        impiegati.forEach(System.out::println);
    }

    public List<Impiegato> getImpiegati() {
        return impiegati;
    }

    public long countImpiegati() {
        return impiegati.stream().filter(i -> i.getStipendio() > 0).count();
    }

    public long countImpiegatiPerEta(int eta) {
        return impiegati.stream().filter(i -> i.getEta() == eta).count();
    }

    public int calcoloMaxEta() {
        return impiegati.stream().mapToInt(Impiegato::getEta).max().orElse(0);
    }
}
