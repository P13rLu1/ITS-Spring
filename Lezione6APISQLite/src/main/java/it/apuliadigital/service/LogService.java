package it.apuliadigital.service;


public interface LogService {


    String getRomano(int numero);

    int getDecimaleRomano(String roman);

    String getBinario(int numero);

    int getDecimaleBinario(String binario);

    String getEsadecimale(int numero);

    int getDecimaleEsadecimale(String esadecimale);
}
