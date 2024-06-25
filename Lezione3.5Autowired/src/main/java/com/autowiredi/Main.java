package com.autowiredi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Fattura fattura = context.getBean("fattura", Fattura.class);

        System.out.println(fattura.stampaFattura());
    }
}