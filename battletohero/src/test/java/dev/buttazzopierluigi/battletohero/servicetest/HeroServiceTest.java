package dev.buttazzopierluigi.battletohero.servicetest;

import dev.buttazzopierluigi.battletohero.entity.HeroEntity;
import dev.buttazzopierluigi.battletohero.entity.RaceEnum;
import dev.buttazzopierluigi.battletohero.repository.HeroRepository;
import dev.buttazzopierluigi.battletohero.service.HeroService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HeroServiceTest {

    @Autowired
    private HeroService heroService;

    @MockBean
    private HeroRepository heroRepository;

    @Test
    @Order(1)
    void testAddHero() {
        // Creazione di un nuovo eroe
        HeroEntity hero = new HeroEntity("Orco Malvagio", RaceEnum.ORC, 100, 10, 10, 10);
        hero.setId(1);

        // Simula il salvataggio dell'eroe
        when(heroRepository.save(hero)).thenReturn(hero);

        // Aggiungi l'eroe
        int result = heroService.addHero(hero);

        // Verifica che l'eroe sia stato aggiunto correttamente
        assertEquals(hero.getId(), result, "The Hero should be added correctly");

        // Verifica che l'eroe sia stato salvato
        verify(heroRepository).save(hero);
    }

    @Test
    @Order(2)
    void testGetAllHeroes() {
        // Simula il recupero di tutti gli eroi
        when(heroRepository.findAll()).thenReturn(null);

        // Recupera tutti gli eroi
        heroService.getHeroes();

        // Verifica che il metodo sia stato chiamato
        verify(heroRepository).findAll();
    }

    @Test
    @Order(3)
    void testGetHeroById() {
        // Creazione di un nuovo eroe
        HeroEntity hero = new HeroEntity("Orco Malvagio", RaceEnum.ORC, 100, 10, 10, 10);
        hero.setId(1);

        // Simula la ricerca dell'eroe
        when(heroRepository.findById(1)).thenReturn(java.util.Optional.of(hero));

        // Ottieni l'eroe
        HeroEntity result = heroService.getHeroById(1);

        // Verifica che l'eroe sia stato trovato
        assertEquals("Orco Malvagio", result.getName(), "The Hero should be found correctly");
    }

    @Test
    @Order(4)
    void testDeleteHero() {
        // Creazione di un nuovo eroe
        HeroEntity hero = new HeroEntity("Orco Malvagio", RaceEnum.ORC, 100, 10, 10, 10);
        hero.setId(1);

        // Simula la cancellazione dell'eroe
        when(heroRepository.findById(1)).thenReturn(java.util.Optional.of(hero));

        // Cancella l'eroe
        heroService.deleteHero(1);

        // Verifica che il metodo sia stato chiamato
        verify(heroRepository).deleteById(1);

        // Verifica che l'eroe sia stato cancellato
        verify(heroRepository).findById(1);
    }

    @Test
    @Order(5)
    void testUpdateHero() {
        // Creazione di un nuovo eroe
        HeroEntity hero = new HeroEntity("Orco Malvagio", RaceEnum.ORC, 100, 10, 10, 10);
        hero.setId(1);

        // Simula l'aggiornamento dell'eroe
        when(heroRepository.findById(1)).thenReturn(java.util.Optional.of(hero));
        when(heroRepository.save(hero)).thenReturn(hero);

        // Aggiorna l'eroe
        heroService.updateHero(hero,1);

        // Verifica che il metodo sia stato chiamato
        verify(heroRepository).findById(1);
        verify(heroRepository).save(hero);

        // Verifica che l'eroe sia stato aggiornato correttamente
        assertEquals("Orco Malvagio", hero.getName(), "The Hero should be updated correctly");
    }
}
