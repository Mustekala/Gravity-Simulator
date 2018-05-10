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
import gravitysimulator.domain.CelestialObject;

/**
 *
 * @author eero
 */

public class GameTest {
    Game game;
    
    @Before
    public void setUp() {
        game = new Game(null);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void canAddStars() {
        CelestialObject o = game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1);
        game.addCelestialObject(o);
        assertEquals(1, game.getObjects().size());
    }
    
    @Test
    public void canAddPlanets() {
        game.addCelestialObject(game.createCelestialObject("planet", "mars", 0, 0, 0, 0, 0, 0, 1));
        assertEquals(1, game.getObjects().size());
    }
    
    @Test
    public void cantAddNonStarsOrNonPlanets() {
        game.addCelestialObject(game.createCelestialObject("teapot", "teatime", 0, 0, 0, 0, 0, 0, 1));
        assertEquals(0, game.getObjects().size());
    }
    
    @Test
    public void canRemoveObjects() {
        game.addCelestialObject(game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1));
        game.removeCelestialObject("sun");
        assertEquals(0, game.getObjects().size());
    }
    
    @Test
    public void canFindObjects() {
        game.addCelestialObject(game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1));       
        assertEquals("sun", game.findCelestialObject("sun").getName());
    }
    
}
