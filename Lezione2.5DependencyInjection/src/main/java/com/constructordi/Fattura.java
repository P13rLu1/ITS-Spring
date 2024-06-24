package com.constructordi;

public class Fattura {
    private Prodotto prodotto;
    private Ordine ordine;

    public Fattura(Prodotto prodotto, Ordine ordine) {
        this.prodotto = prodotto;
        this.ordine = ordine;
    }

    public String stampaFattura() {
        return prodotto.prodotti() + " " + ordine.ordine() + " Sono in fattura";
    }

}
