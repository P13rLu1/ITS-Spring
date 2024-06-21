package com.setterdi.service;

import java.util.List;

public class Biblioteca {

    public Biblioteca() {

    }

    public void setService(BibliotecaService service) {
        this.service = service;
    }

    private BibliotecaService service;

    public List<String> getLibriDisponibili() {
        return service.getBiblioteca();
    }
}
