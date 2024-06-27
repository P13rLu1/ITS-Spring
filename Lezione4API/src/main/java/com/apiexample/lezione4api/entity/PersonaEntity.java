package com.apiexample.lezione4api.entity;

import java.io.Serial;
import java.io.Serializable;

public class PersonaEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 5315219480580631678L;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;

    public PersonaEntity() {
    }

    public PersonaEntity(String nome, String cognome, String email, String telefono) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
