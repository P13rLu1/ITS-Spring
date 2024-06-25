package com.autowiredi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Fattura {

    @Autowired
    private Prodotto prodotto;

    @Autowired
    private Ordine ordine;

    public String stampaFattura() {
        return prodotto.prodotti() + " " + ordine.ordine() + " Sono in fattura";
    }
}
