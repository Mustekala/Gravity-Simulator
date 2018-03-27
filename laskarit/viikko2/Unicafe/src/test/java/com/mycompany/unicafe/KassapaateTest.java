/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eero
 */
public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti maksukortti;
    
    public KassapaateTest() {       
    }
    
    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(1000);
    }

    @Test
    public void rahamaaraOikea() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullisiaLounaitaMyytyOikea() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void maukkaitaLounaitaMyytyOikea() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    //Kateinen
    
    @Test
    public void edullinenKateismaksuToimii() {
        kassapaate.syoEdullisesti(500);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukasKateismaksuToimii() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullinenVaihtorahaOikea() {
        assertEquals(260, kassapaate.syoEdullisesti(500));
    }
    
    @Test
    public void maukasVaihtorahaOikea() {
        assertEquals(100, kassapaate.syoMaukkaasti(500));
    }
    
    @Test
    public void edullistenMaaraKasvaa() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
     
    @Test
    public void maukkaidenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenMaksuEiRiittavaPalauttaaKaiken() {
        assertEquals(100, kassapaate.syoEdullisesti(100));
    }
    
    @Test
    public void maukasMaksuEiRiittavaPalauttaaKaiken() {
        assertEquals(100, kassapaate.syoMaukkaasti(100));
    }
    
    @Test
    public void edullinenMaksuEiRiittavaRahaEiMuutu() {
        kassapaate.syoEdullisesti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void maukasMaksuEiRiittavaRahaEiMuutu() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void edullinenMaksuEiRiittavaMyytyjenMaaraEiMuutu() {
        kassapaate.syoEdullisesti(100);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
 
    @Test
    public void maukasMaksuEiRiittavaMyytyjenMaaraEiMuutu() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    //Maksukortti
    
    @Test
    public void kortillaVoiMaksaaEdullisen() {
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(760, maksukortti.saldo());
    }
    
    @Test
    public void kortillaVoiMaksaaMaukkaan() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(600, maksukortti.saldo());
    }
    
    @Test
    public void korttimaksuEdullisestiPalauttaaTrue() {
        assertTrue(kassapaate.syoEdullisesti(maksukortti));
    }
    
    @Test
    public void korttimaksuMaukkaastiPalauttaaTrue() {
        assertTrue(kassapaate.syoMaukkaasti(maksukortti));
    }
    
    @Test
    public void korttimaksuEdullistenMaaraKasvaa() {
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }
     
    @Test
    public void korttimaksuMaukkaidenMaaraKasvaa() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void korttimaksuEdullinenMaksuEiRiittavaRahaEiMuutu() {
        Maksukortti maksukortti = new Maksukortti(50);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(50, maksukortti.saldo());
    }
    
    @Test
    public void korttimaksuMaukasMaksuEiRiittavaRahaEiMuutu() {
        Maksukortti maksukortti = new Maksukortti(50);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(50, maksukortti.saldo());
    }
    
    @Test
    public void korttimaksuEdullinenMaksuEiRiittavaMyytyjenMaaraEiMuutu() {
        Maksukortti maksukortti = new Maksukortti(50);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
 
    @Test
    public void korttimaksuMaukasMaksuEiRiittavaMyytyjenMaaraEiMuutu() {
        Maksukortti maksukortti = new Maksukortti(50);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksuEdullisestiMaksuEiRiittavaPalauttaaFalse() {
        Maksukortti maksukortti = new Maksukortti(50);
        assertTrue(kassapaate.syoEdullisesti(maksukortti) == false);
    }
    
    @Test
    public void korttimaksuMaukkaastiMaksuEiRiittavaPalauttaaFalse() {
        Maksukortti maksukortti = new Maksukortti(50);
        assertTrue(kassapaate.syoMaukkaasti(maksukortti) == false);
    }
    
    @Test
    public void kassanRahamaaraEiMuutu() {
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaSaldoMuuttuu() {
        maksukortti.lataaRahaa(1000);
        assertEquals(2000, maksukortti.saldo());
    }
    
    @Test
    public void kortilleLadattaessaKassanRahamaaraKasvaa() {
        kassapaate.lataaRahaaKortille(maksukortti, 1000);
        assertEquals(101000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void kortilleLadattaessaNegattivinenKassanRahamaaraEiKasva() {
        kassapaate.lataaRahaaKortille(maksukortti, -1000);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

}


