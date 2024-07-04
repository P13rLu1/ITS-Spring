package it.apuliadigital;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class Lezione7RubricaApplicationTests {

	@MockBean
	private ContattoService contattoService;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	void testAddContact() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail@example.com"); // Use a realistic email format

		when(contattoService.aggiungiContatto(any(ContattoEntity.class))).thenReturn("1");
		when(contattoService.getContattoById("1")).thenReturn(contatto);

		String id = contattoService.aggiungiContatto(contatto);
		ContattoEntity contattoSalvato = contattoService.getContattoById(id);

		// Improved assertions
		assertEquals(contatto.getNome(), contattoSalvato.getNome(), "Name should match");
		assertEquals(contatto.getCognome(), contattoSalvato.getCognome(), "Surname should match");
		assertEquals(contatto.getTelefono(), contattoSalvato.getTelefono(), "Phone should match");
		assertEquals(contatto.getEmail(), contattoSalvato.getEmail(), "Email should match");
		assertNotEquals("", id, "ID should not be empty");

		// Verify that the add method was called exactly once
		Mockito.verify(contattoService, Mockito.times(1)).aggiungiContatto(any(ContattoEntity.class));
	}

	@Test
	@Order(2)
	void testSearchContacts() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		List<ContattoEntity> contattiList = Collections.singletonList(contatto);

		when(contattoService.searchContatti("Mario", "Rossi")).thenReturn(contattiList);
		when(contattoService.searchContatti("Mario", null)).thenReturn(contattiList);
		when(contattoService.searchContatti(null, "Rossi")).thenReturn(contattiList);
		when(contattoService.searchContatti(null, null)).thenReturn(contattiList);

		assertEquals(1, contattoService.searchContatti("Mario", "Rossi").size());
		assertEquals(1, contattoService.searchContatti("Mario", null).size());
		assertEquals(1, contattoService.searchContatti(null, "Rossi").size());
		assertEquals(1, contattoService.searchContatti(null, null).size());

		when(contattoService.searchContatti("Luigi", "Verdi")).thenReturn(Collections.emptyList());
		when(contattoService.searchContatti("Luigi", null)).thenReturn(Collections.emptyList());
		when(contattoService.searchContatti(null, "Verdi")).thenReturn(Collections.emptyList());

		assertEquals(0, contattoService.searchContatti("Luigi", "Verdi").size());
		assertEquals(0, contattoService.searchContatti("Luigi", null).size());
		assertEquals(0, contattoService.searchContatti(null, "Verdi").size());

		assertNotEquals(0, contattoService.searchContatti("Mario", "Rossi").size());
	}

	@Test
	@Order(3)
	void testUpdateContact() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail@example.com");

		ContattoEntity contattoAggiornato = new ContattoEntity();
		contattoAggiornato.setId("1");
		contattoAggiornato.setNome("Luigi");
		contattoAggiornato.setCognome("Rossi");
		contattoAggiornato.setTelefono("1234567890");
		contattoAggiornato.setEmail("mail@example.com");

		when(contattoService.aggiungiContatto(any(ContattoEntity.class))).thenReturn("1");
		when(contattoService.getContattoById("1")).thenReturn(contatto, contattoAggiornato);

		String id = contattoService.aggiungiContatto(contatto);

		ContattoEntity contattoSalvato = contattoService.getContattoById(id);
		contattoSalvato.setNome("Luigi");
		contattoService.aggiungiContatto(contattoSalvato);

		ContattoEntity contattoModificato = contattoService.getContattoById(id);

		// Improved assertions
		assertEquals("Luigi", contattoModificato.getNome(), "Name should be updated");
		assertEquals(contatto.getCognome(), contattoModificato.getCognome(), "Surname should not change");
		assertEquals(contatto.getTelefono(), contattoModificato.getTelefono(), "Phone should not change");
		assertEquals(contatto.getEmail(), contattoModificato.getEmail(), "Email should not change");

		// Verify the update interaction
		Mockito.verify(contattoService, Mockito.times(2)).aggiungiContatto(any(ContattoEntity.class));
	}

	@Test
	@Order(4)
	void testDeleteContact() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail@example.com");

		when(contattoService.aggiungiContatto(any(ContattoEntity.class))).thenReturn("1");
		when(contattoService.searchContatti("Mario", "Rossi")).thenReturn(Collections.emptyList());

		String id = contattoService.aggiungiContatto(contatto);
		contattoService.eliminaContatto(id);

		// Improved assertions
		assertEquals(0, contattoService.searchContatti("Mario", "Rossi").size(), "Contact should be deleted");
		assertTrue(contattoService.searchContatti("Mario", "Rossi").isEmpty(), "Search result should be empty");

		// Verify delete interaction
		Mockito.verify(contattoService, Mockito.times(1)).eliminaContatto(id);
	}


	@Test
	@Order(5)
	void testGetContacts() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		List<ContattoEntity> contattiList = Collections.singletonList(contatto);

		when(contattoService.getContatti()).thenReturn(contattiList);

		assertNotEquals(0, contattoService.getContatti().size());
	}

	@Test
	@Order(6)
	void testDeleteAllContacts() {
		when(contattoService.getContatti()).thenReturn(Collections.emptyList());

		contattoService.getContatti().forEach(contatto -> contattoService.eliminaContatto(contatto.getId()));

		assertEquals(0, contattoService.getContatti().size());
	}
}
