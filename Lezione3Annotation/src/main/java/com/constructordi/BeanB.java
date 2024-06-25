package com.constructordi;

import org.springframework.stereotype.Component;

@Component
public class BeanB {

    String message = "Ciao questo è il BeanB";

    public String hello() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
