package it.apuliadigital;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class Lezione7RubricaApplicationTests {

	@Autowired
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
		contatto.setEmail("mail");

		String id = contattoService.aggiungiContatto(contatto);
		ContattoEntity contattoSalvato = contattoService.getContattoById(id);

		assertEquals(contatto.getNome(), contattoSalvato.getNome());
		assertEquals(contatto.getCognome(), contattoSalvato.getCognome());
		assertEquals(contatto.getTelefono(), contattoSalvato.getTelefono());
		assertEquals(contatto.getEmail(), contattoSalvato.getEmail());
		assertNotEquals("", id);
	}

	@Test
	@Order(2)
	void testSearchContacts() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		contattoService.aggiungiContatto(contatto);

		assertEquals(1, contattoService.searchContatti("Mario", "Rossi").size());
		assertEquals(1, contattoService.searchContatti("Mario", null).size());
		assertEquals(1, contattoService.searchContatti(null, "Rossi").size());
		assertEquals(1, contattoService.searchContatti(null, null).size());

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
		contatto.setEmail("mail");

		String id = contattoService.aggiungiContatto(contatto);

		ContattoEntity contattoSalvato = contattoService.getContattoById(id);
		contattoSalvato.setNome("Luigi");
		contattoService.aggiungiContatto(contattoSalvato);

		ContattoEntity contattoModificato = contattoService.getContattoById(id);

		assertEquals("Luigi", contattoModificato.getNome());
		assertEquals(contatto.getCognome(), contattoModificato.getCognome());
		assertEquals(contatto.getTelefono(), contattoModificato.getTelefono());
		assertEquals(contatto.getEmail(), contattoModificato.getEmail());

		assertNotEquals(contatto.getNome(), contattoModificato.getNome());
	}

	@Test
	@Order(4)
	void testDeleteContact() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		String id = contattoService.aggiungiContatto(contatto);

		contattoService.eliminaContatto(id);

		assertEquals(0, contattoService.searchContatti("Mario", "Rossi").size());

		assertNotEquals(1, contattoService.searchContatti("Mario", "Rossi").size());
	}

	@Test
	@Order(5)
	void testGetContacts() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		contattoService.aggiungiContatto(contatto);

		assertNotEquals(0, contattoService.getContatti().size());
	}

	@Test
	@Order(6)
	void testGetContact() {
		ContattoEntity contatto = new ContattoEntity();
		contatto.setNome("Mario");
		contatto.setCognome("Rossi");
		contatto.setTelefono("1234567890");
		contatto.setEmail("mail");

		String id = contattoService.aggiungiContatto(contatto);

		ContattoEntity contattoSalvato = contattoService.getContattoById(id);

		assertNotEquals(null, contattoSalvato);
		assertEquals(id, contattoSalvato.getId());
		assertEquals(contatto.getNome(), contattoSalvato.getNome());
		assertEquals(contatto.getCognome(), contattoSalvato.getCognome());
		assertEquals(contatto.getTelefono(), contattoSalvato.getTelefono());
		assertEquals(contatto.getEmail(), contattoSalvato.getEmail());
	}

	@Test
	@Order(7)
	void testDeleteAllContacts() {
		contattoService.getContatti().forEach(contatto -> contattoService.eliminaContatto(contatto.getId()));

		assertEquals(0, contattoService.getContatti().size());
	}

	@Test
	@Order(8)
	void testSearchContactsEmpty() {
		assertEquals(0, contattoService.searchContatti("Mario", "Rossi").size());
		assertEquals(0, contattoService.searchContatti("Mario", null).size());
		assertEquals(0, contattoService.searchContatti(null, "Rossi").size());
		assertEquals(0, contattoService.searchContatti(null, null).size());
	}
}
