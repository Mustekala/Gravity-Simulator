package gravitysimulator.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests functionality of CelestialObjects (stars and planets)
 * @author eero
 */
public class CelestialObjectTest {
    
    Star star;
    
    @Before
    public void setUp() {
        star = new Star(1, "sun", 400, 300, -10, 0, 100, 100, 1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void canGetName() {
        Planet planet =  new Planet(1, "earth", 400, 300, 0, 0, 100, 10, 1);
        assertEquals("earth", planet.getName());
    }
    
    @Test
    public void canGetPosition() {
        assertEquals(400, star.getX(), 0);
        assertEquals(300, star.getY(), 0);
    }
 
    @Test
    public void canSetPosition() {
        star.setPosition(1, 2);
        assertEquals(1, star.getX(), 0);
        assertEquals(2, star.getY(), 0);
    }
    
    @Test
    public void canGetSpeed() {
        assertEquals(-10, star.getXSpeed(), 0);
        assertEquals(0, star.getYSpeed(), 0);
    }
    
    @Test
    public void canSetSpeed() {
        star.setSpeed(0, 10);
        assertEquals(0, star.getXSpeed(), 0);
        assertEquals(10, star.getYSpeed(), 0);
    }
    
    @Test
    public void canGetMass() {
        assertEquals(100, star.getMass(), 0);
    }
    
    @Test
    public void canGetSize() {
        assertEquals(100, star.getSize(), 0);
    }
    
    @Test
    public void canGetImage() {
        //assertEquals("/images/stars/star1.png", star.getImage());
    }
}
