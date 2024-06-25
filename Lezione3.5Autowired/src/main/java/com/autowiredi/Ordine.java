package com.autowiredi;

import org.springframework.stereotype.Component;

@Component
public class Ordine {

    public String ordine(){
        return "Sono dentro ordine";
    }
}
