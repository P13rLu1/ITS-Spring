package com.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Ordine ordine = context.getBean("ordine", Ordine.class);
        Prodotto prodotto = context.getBean("prodotto", Prodotto.class);

        System.out.println(ordine.HelloWorld() + "\n" + prodotto.listaProdotto());
    }
}