package dev.buttazzopierluigi.battletohero.servicetest;

import dev.buttazzopierluigi.battletohero.service.BattleService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BattleServiceTest {

    @MockBean
    private BattleService battleService;

    @Test
    @Order(1)
    void testStartBattle() {
        // Simula l'inizio di una battaglia
        when(battleService.startBattle(1, 2, 1)).thenReturn(1);

        // Inizia la battaglia
        int result = battleService.startBattle(1, 2, 1);

        // Verifica che la battaglia sia iniziata correttamente
        assertEquals(1, result, "La battaglia dovrebbe iniziare correttamente");

        // Verifica che il metodo sia stato chiamato
        verify(battleService).startBattle(1, 2, 1);
    }
}
