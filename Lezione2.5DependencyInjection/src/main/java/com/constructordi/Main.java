package com.constructordi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        // Metodo senza beans
        Fattura fattura1 = new Fattura(new Prodotto(), new Ordine());
        System.out.println(fattura1.stampaFattura() + " metodo senza beans");

        // Metodo con beans
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Fattura fattura = context.getBean("fattura", Fattura.class);

        System.out.println(fattura.stampaFattura() + " metodo con beans");
    }
}