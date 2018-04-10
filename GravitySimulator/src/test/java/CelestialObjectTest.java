/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.CelestialObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eero
 */
public class CelestialObjectTest {
    
    CelestialObject object;
    
    @Before
    public void setUp() {
        object = new CelestialObject("sun", 400, 300, -10, 0, 100, 100);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void canGetPosition() {
        assertEquals(400, object.getX(), 0);
        assertEquals(300, object.getY(), 0);
    }
}
