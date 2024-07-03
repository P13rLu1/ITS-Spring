package it.apuliadigital;

import it.apuliadigital.service.LogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class Lezione6ApisqLiteApplicationTests {

    @Autowired
    private LogService logService;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    @Order(1)
    void testGetRomano(){
        assertEquals("I", logService.getRomano(1));
        assertEquals("II", logService.getRomano(2));
        assertEquals("III", logService.getRomano(3));
        assertEquals("IV", logService.getRomano(4));
        assertEquals("V", logService.getRomano(5));
        assertEquals("VI", logService.getRomano(6));
        assertEquals("VII", logService.getRomano(7));
        assertEquals("IX", logService.getRomano(9));
        assertEquals("X", logService.getRomano(10));
        assertEquals("XI", logService.getRomano(11));
        assertEquals("XX", logService.getRomano(20));
        assertEquals("XXX", logService.getRomano(30));
        assertEquals("XL", logService.getRomano(40));
        assertEquals("L", logService.getRomano(50));
        assertEquals("LX", logService.getRomano(60));
        assertEquals("LXX", logService.getRomano(70));
        assertEquals("XC", logService.getRomano(90));
        assertEquals("C", logService.getRomano(100));
        assertEquals("CC", logService.getRomano(200));
        assertEquals("CM", logService.getRomano(900));
        assertEquals("M", logService.getRomano(1000));

        assertNotEquals("I", logService.getRomano(2));
    }

    @Test
    @Order(2)
    void testGetDecimaleRomano(){
        assertEquals(1, logService.getDecimaleRomano("I"));
        assertEquals(2, logService.getDecimaleRomano("II"));
        assertEquals(3, logService.getDecimaleRomano("III"));
        assertEquals(4, logService.getDecimaleRomano("IV"));
        assertEquals(5, logService.getDecimaleRomano("V"));
        assertEquals(6, logService.getDecimaleRomano("VI"));
        assertEquals(7, logService.getDecimaleRomano("VII"));
        assertEquals(9, logService.getDecimaleRomano("IX"));
        assertEquals(10, logService.getDecimaleRomano("X"));
        assertEquals(11, logService.getDecimaleRomano("XI"));
        assertEquals(20, logService.getDecimaleRomano("XX"));
        assertEquals(30, logService.getDecimaleRomano("XXX"));
        assertEquals(40, logService.getDecimaleRomano("XL"));
        assertEquals(50, logService.getDecimaleRomano("L"));
        assertEquals(60, logService.getDecimaleRomano("LX"));
        assertEquals(70, logService.getDecimaleRomano("LXX"));
        assertEquals(90, logService.getDecimaleRomano("XC"));
        assertEquals(100, logService.getDecimaleRomano("C"));
        assertEquals(200, logService.getDecimaleRomano("CC"));
        assertEquals(900, logService.getDecimaleRomano("CM"));
        assertEquals(1000, logService.getDecimaleRomano("M"));

        assertNotEquals(1, logService.getDecimaleRomano("II"));
    }

    @Test
    @Order(3)
    void testGetBinario(){
        assertEquals("1", logService.getBinario(1));
        assertEquals("10", logService.getBinario(2));
        assertEquals("11", logService.getBinario(3));
        assertEquals("100", logService.getBinario(4));
        assertEquals("101", logService.getBinario(5));
        assertEquals("110", logService.getBinario(6));
        assertEquals("111", logService.getBinario(7));
        assertEquals("1001", logService.getBinario(9));
        assertEquals("1010", logService.getBinario(10));
        assertEquals("1011", logService.getBinario(11));
        assertEquals("10100", logService.getBinario(20));
        assertEquals("11110", logService.getBinario(30));
        assertEquals("101000", logService.getBinario(40));
        assertEquals("110010", logService.getBinario(50));
        assertEquals("111100", logService.getBinario(60));
        assertEquals("1000110", logService.getBinario(70));
        assertEquals("1011010", logService.getBinario(90));
        assertEquals("1100100", logService.getBinario(100));
        assertEquals("11001000", logService.getBinario(200));
        assertEquals("1110000100", logService.getBinario(900));
        assertEquals("1111101000", logService.getBinario(1000));

        assertNotEquals("1", logService.getBinario(2));
    }

    @Test
    @Order(4)
    void testGetDecimaleBinario(){
        assertEquals(1, logService.getDecimaleBinario("1"));
        assertEquals(2, logService.getDecimaleBinario("10"));
        assertEquals(3, logService.getDecimaleBinario("11"));
        assertEquals(4, logService.getDecimaleBinario("100"));
        assertEquals(5, logService.getDecimaleBinario("101"));
        assertEquals(6, logService.getDecimaleBinario("110"));
        assertEquals(7, logService.getDecimaleBinario("111"));
        assertEquals(9, logService.getDecimaleBinario("1001"));
        assertEquals(10, logService.getDecimaleBinario("1010"));
        assertEquals(11, logService.getDecimaleBinario("1011"));
        assertEquals(20, logService.getDecimaleBinario("10100"));
        assertEquals(30, logService.getDecimaleBinario("11110"));
        assertEquals(40, logService.getDecimaleBinario("101000"));
        assertEquals(50, logService.getDecimaleBinario("110010"));
        assertEquals(60, logService.getDecimaleBinario("111100"));
        assertEquals(70, logService.getDecimaleBinario("1000110"));
        assertEquals(90, logService.getDecimaleBinario("1011010"));
        assertEquals(100, logService.getDecimaleBinario("1100100"));
        assertEquals(200, logService.getDecimaleBinario("11001000"));
        assertEquals(900, logService.getDecimaleBinario("1110000100"));
        assertEquals(1000, logService.getDecimaleBinario("1111101000"));

        assertNotEquals(1, logService.getDecimaleBinario("10"));
    }

    @Test
    @Order(5)
    void testGetEsadecimale(){
        assertEquals("1", logService.getEsadecimale(1));
        assertEquals("2", logService.getEsadecimale(2));
        assertEquals("3", logService.getEsadecimale(3));
        assertEquals("4", logService.getEsadecimale(4));
        assertEquals("5", logService.getEsadecimale(5));
        assertEquals("6", logService.getEsadecimale(6));
        assertEquals("7", logService.getEsadecimale(7));
        assertEquals("9", logService.getEsadecimale(9));
        assertEquals("a", logService.getEsadecimale(10));
        assertEquals("b", logService.getEsadecimale(11));
        assertEquals("14", logService.getEsadecimale(20));
        assertEquals("1e", logService.getEsadecimale(30));
        assertEquals("28", logService.getEsadecimale(40));
        assertEquals("32", logService.getEsadecimale(50));
        assertEquals("3c", logService.getEsadecimale(60));
        assertEquals("46", logService.getEsadecimale(70));
        assertEquals("5a", logService.getEsadecimale(90));
        assertEquals("64", logService.getEsadecimale(100));
        assertEquals("c8", logService.getEsadecimale(200));
        assertEquals("384", logService.getEsadecimale(900));
        assertEquals("3e8", logService.getEsadecimale(1000));

        assertNotEquals("1", logService.getEsadecimale(2));
    }

    @Test
    @Order(6)
    void testGetDecimaleEsadecimale() {
        assertEquals(1, logService.getDecimaleEsadecimale("1"));
        assertEquals(2, logService.getDecimaleEsadecimale("2"));
        assertEquals(3, logService.getDecimaleEsadecimale("3"));
        assertEquals(4, logService.getDecimaleEsadecimale("4"));
        assertEquals(5, logService.getDecimaleEsadecimale("5"));
        assertEquals(6, logService.getDecimaleEsadecimale("6"));
        assertEquals(7, logService.getDecimaleEsadecimale("7"));
        assertEquals(9, logService.getDecimaleEsadecimale("9"));
        assertEquals(10, logService.getDecimaleEsadecimale("A"));
        assertEquals(11, logService.getDecimaleEsadecimale("B"));
        assertEquals(20, logService.getDecimaleEsadecimale("14"));
        assertEquals(30, logService.getDecimaleEsadecimale("1E"));
        assertEquals(40, logService.getDecimaleEsadecimale("28"));
        assertEquals(50, logService.getDecimaleEsadecimale("32"));
        assertEquals(60, logService.getDecimaleEsadecimale("3C"));
        assertEquals(70, logService.getDecimaleEsadecimale("46"));
        assertEquals(90, logService.getDecimaleEsadecimale("5A"));
        assertEquals(100, logService.getDecimaleEsadecimale("64"));
        assertEquals(200, logService.getDecimaleEsadecimale("C8"));
        assertEquals(900, logService.getDecimaleEsadecimale("384"));
        assertEquals(1000, logService.getDecimaleEsadecimale("3E8"));

        assertNotEquals(1, logService.getDecimaleEsadecimale("2"));
    }
}
