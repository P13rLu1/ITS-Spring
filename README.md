# ITS-Spring

![License](https://img.shields.io/github/license/P13rLu1/ITS-Spring)
![Java](https://img.shields.io/badge/Java-11+-brightgreen)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5+-blue)

Repository per il progetto ITS-Spring. Questo progetto è una demo per un'applicazione basata su Spring Boot, che mostra funzionalità di base come gestione delle dipendenze, configurazione, e uso dei principali moduli di Spring.

## Sommario

- [Descrizione](#descrizione)
- [Caratteristiche](#caratteristiche)
- [Requisiti](#requisiti)
- [Installazione](#installazione)
- [Utilizzo](#utilizzo)
- [Test](#test)
- [Contributi](#contributi)
- [Licenza](#licenza)
- [Contatti](#contatti)

## Descrizione

ITS-Spring è una demo che illustra come costruire applicazioni Java usando il framework Spring Boot. Include esempi su come configurare un progetto Spring Boot, integrare database, gestire la sicurezza e implementare REST API.

## Caratteristiche

- **Configurazione semplice**: Uso di Spring Boot per una configurazione rapida.
- **Gestione delle dipendenze**: Usa Maven per gestire le dipendenze.
- **REST API**: Implementazione di endpoint REST.
- **Persistenza**: Integrazione con un database relazionale.
- **Sicurezza**: Implementazione di base della sicurezza.
- **Testing**: Configurato per test di unità e di integrazione.

## Requisiti

- **Java 11 o superiore**: [Installazione Java](https://adoptium.net/)
- **Maven**: [Installazione Maven](https://maven.apache.org/install.html)
- **Git**: [Installazione Git](https://git-scm.com/)

## Installazione

1. **Clonare il repository:**

    ```bash
    git clone https://github.com/P13rLu1/ITS-Spring.git
    cd ITS-Spring
    ```

2. **Costruire il progetto:**

    ```bash
    mvn clean install
    ```

## Utilizzo

1. **Avviare l'applicazione:**

    ```bash
    mvn spring-boot:run
    ```

2. **Accedere all'applicazione:**

    L'applicazione sarà disponibile su `http://localhost:8080`.

3. **Documentazione API:**

    Visita `http://localhost:8080/swagger-ui.html` per esplorare la documentazione delle API (se Swagger è configurato).

## Test

1. **Eseguire i test:**

    ```bash
    mvn test
    ```

2. **Test di integrazione:**

    Configura i test di integrazione in `src/test/java`.

## Contributi

Contributi sono benvenuti! Segui questi passaggi:

1. **Fork** il progetto.
2. **Crea** una nuova branch: `git checkout -b my-feature`
3. **Fai** i tuoi cambiamenti.
4. **Commit**: `git commit -m 'Aggiungi una nuova feature'`
5. **Push**: `git push origin my-feature`
6. **Crea** una pull request.

Per dettagli aggiuntivi, consulta il [CONTRIBUTING.md](CONTRIBUTING.md).

## Licenza

Distribuito sotto la licenza MIT. Vedi [LICENSE](LICENSE) per maggiori informazioni.

## Contatti

- **Autore**: Pier
- **Email**: [pbuttazzo@studenti.apuliadigitalmaker.it](mailto:pbuttazzo@studenti.apuliadigitalmaker.it)

---

Realizzato con ❤️ da [P13rLu1](https://github.com/P13rLu1)
