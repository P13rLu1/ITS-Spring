package it.apuliadigital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class ContattoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String cognome;
    private String telefono;
    private String email;

    public ContattoEntity() {
    }

    public ContattoEntity(String nome, String cognome, String telefono, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.telefono = telefono;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContattoEntity that = (ContattoEntity   ) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cognome, telefono, email);
    }

    @Override
    public String toString() {
        return "PersonaEntity{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
