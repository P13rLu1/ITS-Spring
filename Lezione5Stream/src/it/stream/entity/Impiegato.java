package it.stream.entity;

public class Impiegato {
    private String nome;
    private String cognome;
    private float stipendio;
    private int eta;

    public Impiegato(String nome, String cognome, float stipendio, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.stipendio = stipendio;
        this.eta = eta;
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

    public float getStipendio() {
        return stipendio;
    }

    public void setStipendio(float stipendio) {
        this.stipendio = stipendio;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Impiegato{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", stipendio=" + stipendio +
                '}';
    }
}
