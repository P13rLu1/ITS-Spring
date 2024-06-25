package com.autowiredi;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Prodotto {

    public List<String> prodotti(){
        List<String> prodotti = new ArrayList<>();

        prodotti.add("Prodotto 1");
        prodotti.add("Prodotto 2");
        prodotti.add("Prodotto 3");

        return prodotti;
    }
}
