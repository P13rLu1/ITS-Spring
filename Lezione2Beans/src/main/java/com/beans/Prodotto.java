package com.beans;

import java.util.ArrayList;
import java.util.List;

public class Prodotto {

    public List<String> listaProdotto() {
        List<String> lista = new ArrayList<>();

        lista.add("Prodotto 1");
        lista.add("Prodotto 2");
        lista.add("Prodotto 3");

        return lista;
    }
}
