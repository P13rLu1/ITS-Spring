package com.setterdi.service;

import com.setterdi.service.impl.BibliotecaServiceImpl;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.setService(new BibliotecaServiceImpl());

        System.out.println(biblioteca.getLibriDisponibili());
    }
}