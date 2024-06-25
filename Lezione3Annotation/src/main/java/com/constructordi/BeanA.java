package com.constructordi;

import org.springframework.stereotype.Component;

@Component
public class BeanA {

    String message = "Ciao questo è il BeanA";

    public String hello() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
