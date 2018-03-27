package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoOikein() {
        assertEquals(1000, kortti.saldo());      
    }
    
    @Test
    public void saldoKasvaaLisattaessa() {
        kortti.lataaRahaa(250);
        assertEquals("saldo: 12.50", kortti.toString());      
    }
    
    @Test
    public void saldoVaheneeOtettaessa() {
        kortti.otaRahaa(250);
        assertEquals("saldo: 7.50", kortti.toString());      
    }
    
    @Test
    public void saldoEiMuutuJosEiVaraa() {
        kortti.otaRahaa(1100);
        assertEquals("saldo: 10.0", kortti.toString());      
    }
       
    @Test
    public void metodiPalauttaaTrueJosVaraa() {
        kortti.otaRahaa(1100);
        assertTrue(kortti.otaRahaa(900));      
    }
    
    @Test
    public void metodiPalauttaaFalseJosEiVaraa() {
        kortti.otaRahaa(1100);
        assertTrue(kortti.otaRahaa(1100) == false);      
    }
    
}
