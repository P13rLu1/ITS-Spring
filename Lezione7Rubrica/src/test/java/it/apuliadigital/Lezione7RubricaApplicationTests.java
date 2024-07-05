package it.apuliadigital;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.repository.ContattoRepository;
import it.apuliadigital.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class Lezione7RubricaApplicationTests {

    @Autowired
    private ContattoService contattoService;
    @MockBean
    private ContattoRepository contattoRepository;

    @Test
    @Order(1)
    void testAddContact() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail");
        contatto.setId("1");

        // Simula il salvataggio del contatto
        when(contattoRepository.save(contatto)).thenReturn(contatto);

        // Aggiungi il contatto
        String result = contattoService.aggiungiContatto(contatto);

        // Verifica che il contatto sia stato aggiunto correttamente
        assertEquals(contatto.getId(), result, "Il Contatto dovrebbe essere aggiunto correttamente");

        // Verifica che il contatto sia stato salvato
        verify(contattoRepository).save(contatto);
    }

    @Test
    @Order(2)
    void testGetContactById() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail");
        contatto.setId("1");

        // Simula la ricerca del contatto
        when(contattoRepository.findById("1")).thenReturn(java.util.Optional.of(contatto));

        // Ottieni il contatto
        ContattoEntity result = contattoService.getContattoById("1");

        // Verifica che il contatto sia stato trovato
        assertNotNull(result, "Contact should be found");

        // Verifica che il contatto sia stato trovato correttamente
        assertEquals("Mario", result.getNome(), "Il contatto dovrebbe essere trovato correttamente");
        assertEquals("Rossi", result.getCognome(), "Il contatto dovrebbe essere trovato correttamente");
        assertEquals("1234567890", result.getTelefono(), "Il contatto dovrebbe essere trovato correttamente");
        assertEquals("mail", result.getEmail(), "Il contatto dovrebbe essere trovato correttamente");

        // Verifica che il contatto sia stato trovato
        verify(contattoRepository).findById("1");
    }

    @Test
    @Order(3)
    void testGetContacts() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail");
        contatto.setId("1");

        // Simula la ricerca dei contatti
        when(contattoRepository.findAll()).thenReturn(Collections.singletonList(contatto));

        // Ottieni i contatti
        List<ContattoEntity> result = contattoService.getContatti();

        // Verifica che i contatti siano stati trovati
        assertNotNull(result, "Contacts should be found");

        // Verifica che i contatti siano stati trovati correttamente
        assertEquals(1, result.size(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("Mario", result.get(0).getNome(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("Rossi", result.get(0).getCognome(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("1234567890", result.get(0).getTelefono(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("mail", result.get(0).getEmail(), "I contatti dovrebbero essere trovati correttamente");

        // Verifica che i contatti siano stati trovati
        verify(contattoRepository).findAll();
    }

    @Test
    @Order(4)
    void testSearchContacts() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rossi", "1234567890", "mail");
        contatto.setId("1");

        // Simula la ricerca dei contatti
        when(contattoRepository.searchByNomeAndCognome("Mario", "Rossi")).thenReturn(Collections.singletonList(contatto));

        // Cerca i contatti
        List<ContattoEntity> result = contattoService.searchContatti("Mario", "Rossi");

        // Verifica che i contatti siano stati trovati
        assertNotNull(result, "Contacts should be found");

        // Verifica che i contatti siano stati trovati correttamente
        assertEquals(1, result.size(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("Mario", result.get(0).getNome(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("Rossi", result.get(0).getCognome(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("1234567890", result.get(0).getTelefono(), "I contatti dovrebbero essere trovati correttamente");
        assertEquals("mail", result.get(0).getEmail(), "I contatti dovrebbero essere trovati correttamente");

        // Verifica che i contatti siano stati trovati
        verify(contattoRepository).searchByNomeAndCognome("Mario", "Rossi");
    }

    @Test
    @Order(5)
    void testUpdateContact() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rotti", "1234567890", "mail");
        contatto.setId("1");

        // Simula il salvataggio del contatto
        when(contattoRepository.save(contatto)).thenReturn(contatto);

        // Aggiorna il contatto
        contattoService.aggiungiContatto(contatto);

        // Verifica che il contatto sia stato aggiornato correttamente
        verify(contattoRepository).save(contatto);
    }

    @Test
    @Order(6)
    void testDeleteContact() {
        // Create un nuovo contatto
        ContattoEntity contatto = new ContattoEntity("Mario", "Rotti", "1234567890", "mail");
        contatto.setId("1");

        // Simula la ricerca del contatto
        when(contattoRepository.findById("1")).thenReturn(java.util.Optional.of(contatto));

        // Elimina il contatto
        contattoService.eliminaContatto("1");

        // Verifica che il contatto sia stato eliminato correttamente
        verify(contattoRepository).deleteById("1");
    }

    @Test
    @Order(7)
    void testDeleteContactNotFound() {
        // Simula la ricerca del contatto
        when(contattoRepository.findById("1")).thenReturn(java.util.Optional.empty());

        // Elimina il contatto
        assertThrows(Exception.class, () -> contattoService.eliminaContatto("1"), "Il contatto non dovrebbe essere trovato");

        // Verifica che il contatto non sia stato trovato
        verify(contattoRepository).findById("1");
    }
}
