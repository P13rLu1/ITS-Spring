package com.constructordi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    private String message = "Ciao questo è il BeanA";
    @Value("${message}")
    private String matino;

    public String hello() {
        return message;
    }

    public String getMatino() {
        return matino;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
