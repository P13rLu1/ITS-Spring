package com.constructordi;

public class Fattura {
    private Prodotto prodotto;
    private Ordine ordine;
    private String autowiredTest;

    public Fattura() { //Prodotto prodotto, Ordine ordine
//        this.prodotto = prodotto;
//        this.ordine = ordine;
    }

    public String setAutowiredTest() {
        return autowiredTest + " Autowired";
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public String stampaFattura() {
        return prodotto.prodotti() + " " + ordine.ordine() + " Sono in fattura" + setAutowiredTest();
    }

}
