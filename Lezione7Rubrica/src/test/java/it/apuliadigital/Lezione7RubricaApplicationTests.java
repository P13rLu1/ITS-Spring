package it.apuliadigital;

import it.apuliadigital.entity.ContattoEntity;
import it.apuliadigital.service.ContattoService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

		assert contattoSalvato != null;

		assert contattoSalvato.getNome().equals(contatto.getNome());
		assert contattoSalvato.getCognome().equals(contatto.getCognome());
		assert contattoSalvato.getTelefono().equals(contatto.getTelefono());
		assert contattoSalvato.getEmail().equals(contatto.getEmail());
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

		assert contattoService.searchContatti("Mario", "Rossi").size() == 1;
		assert contattoService.searchContatti("Mario", null).size() == 1;
		assert contattoService.searchContatti(null, "Rossi").size() == 1;
		assert contattoService.searchContatti(null, null).size() == 1;
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

		assert contattoModificato != null;
		assert contattoModificato.getNome().equals("Luigi");
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

		assert contattoService.getContattoById(id) == null;
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

		assert !contattoService.getContatti().isEmpty();
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

		assert contattoSalvato != null;

		assert contattoSalvato.getNome().equals(contatto.getNome());
		assert contattoSalvato.getCognome().equals(contatto.getCognome());
		assert contattoSalvato.getTelefono().equals(contatto.getTelefono());
		assert contattoSalvato.getEmail().equals(contatto.getEmail());
	}

	@Test
	@Order(7)
	void testSearchContactsNotFound() {
		assert contattoService.searchContatti("Mario", "Rossi").isEmpty();
		assert contattoService.searchContatti("Mario", null).isEmpty();
		assert contattoService.searchContatti(null, "Rossi").isEmpty();
		assert contattoService.searchContatti(null, null).isEmpty();
	}
}
