/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gravitysimulator.domain.Game;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author eero
 */
public class GameTest {
    Game game;
    
        @Before
    public void setUp() {
        game = new Game();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void canAddStars() {
        game.addCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0);
        assertEquals(1, game.objects.size());
    }
    
    @Test
    public void canAddPlanets() {
        game.addCelestialObject("planet", "mars", 0, 0, 0, 0, 0, 0);
        assertEquals(1, game.objects.size());
    }
    
    @Test
    public void cantAddNonStarsOrNonPlanets() {
        game.addCelestialObject("teapot", "teatime", 0, 0, 0, 0, 0, 0);
        assertEquals(0, game.objects.size());
    }
    
    @Test
    public void canRemoveObjects() {
        game.addCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0);
        game.removeCelestialObject("sun");
        assertEquals(0, game.objects.size());
    }
    
    @Test
    public void canFindObjects() {
        game.addCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0);       
        assertEquals("sun", game.findCelestialObject("sun").getName());
    }
}
