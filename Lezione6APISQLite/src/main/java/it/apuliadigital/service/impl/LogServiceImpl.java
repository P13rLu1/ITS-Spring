package it.apuliadigital.service.impl;

import it.apuliadigital.entity.LogEntity;
import it.apuliadigital.entity.repository.LogRepository;
import it.apuliadigital.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;
    private String timestamp;
    private String[] romani = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] arabici = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    // Funzione che aggiunge un log al database
    private void addLog(LogEntity log) {
        try {
            logRepository.save(log);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Funzione che restituisce la data e l'ora attuale
    private String getTimestamp() {
        LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return timestamp.format(formatter);
    }

    // Funzione che converte un numero decimale in romano
    @Override
    public String getRomano(int numero) {
        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < arabici.length; i++) {
            while (numero >= arabici[i]) {
                numero -= arabici[i];
                romano.append(romani[i]);
            }
        }

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getRomano", "Fatta Conversione In Numero Romano", timestamp);
        addLog(log);

        return romano.toString();
    }

    // Funzione che converte un numero romano in decimale
    @Override
    public int getDecimaleRomano(String roman) {
        int decimale = 0;
        int i = 0;
        for (int j = 0; j < romani.length; j++) {
            while (roman.indexOf(romani[j], i) == i) {
                decimale += arabici[j];
                i += romani[j].length();
            }
        }

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getDecimaleRomano", "Fatta Conversione In Numero Decimale Da Numero Romano", timestamp);
        addLog(log);

        return decimale;
    }

    // Funzione che converte un numero decimale in binario
    @Override
    public String getBinario(int numero) {
        String binario = Integer.toBinaryString(numero);

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getBinario", "Fatta Conversione In Numero Binario", timestamp);
        addLog(log);

        return binario;
    }

    // Funzione che converte un numero binario in decimale
    @Override
    public int getDecimaleBinario(String binario) {
        int decimale = Integer.parseInt(binario, 2);

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getDecimaleBinario", "Fatta Conversione In Numero Decimale Da Numero Binario", timestamp);
        addLog(log);

        return decimale;
    }

    // Funzione che converte un numero decimale in esadecimale
    @Override
    public String getEsadecimale(int numero) {
        String esadecimale = Integer.toHexString(numero);

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getEsadecimale", "Fatta Conversione In Numero Esadecimale", timestamp);
        addLog(log);

        return esadecimale;
    }

    // Funzione che converte un numero esadecimale in decimale
    @Override
    public int getDecimaleEsadecimale(String esadecimale) {
        int decimale = Integer.parseInt(esadecimale, 16);

        timestamp = getTimestamp();
        LogEntity log = new LogEntity("/getDecimaleEsadecimale", "Fatta Conversione In Numero Decimale Da Numero Esadecimale", timestamp);
        addLog(log);

        return decimale;
    }
}
