package com.setterdi.service.impl;

import com.setterdi.service.BibliotecaService;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServiceImpl implements BibliotecaService {

    @Override
    public List<String> getBiblioteca() {
        List<String> libriArray = new ArrayList<>();
        libriArray.add("Il signore degli anelli");
        libriArray.add("Il vecchio e il mare");
        libriArray.add("Il nome della rosa");

        return libriArray;
    }
}
