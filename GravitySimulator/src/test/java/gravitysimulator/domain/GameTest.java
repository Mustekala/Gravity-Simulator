package gravitysimulator.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests game functionality. 
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
    public void notDefinedObjectsArePlanets() {
        game.addCelestialObject(game.createCelestialObject("teapot", "teatime", 0, 0, 0, 0, 0, 0, 1));
        assertEquals(game.getObjects().get(0).getType(), "planet");
    }
    
    @Test
    public void canRemoveObjectsByName() {
        game.addCelestialObject(game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1));
        game.removeCelestialObject("sun");
        assertEquals(0, game.getObjects().size());
    }
    
    @Test
    public void canRemoveObjects() {
        CelestialObject object = game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1);
        game.addCelestialObject(object);
        game.removeCelestialObject(object);
        assertEquals(0, game.getObjects().size());
    }
    
    @Test
    public void canFindObjects() {
        game.addCelestialObject(game.createCelestialObject("star", "sun", 0, 0, 0, 0, 0, 0, 1));       
        assertEquals("sun", game.findCelestialObject("sun").getName());
    }
    
    //Gravity should be applied to both objects
    @Test
    public void gravityWorks() {
        CelestialObject o1 = game.createCelestialObject("star", "sun", 0, 0, 0, 0, 1000, 100, 1);
        game.addCelestialObject(o1);
        CelestialObject o2 = game.createCelestialObject("star", "otherSun", 500, 500, 0, 0, 1000, 100, 1);
        game.addCelestialObject(o2);
        game.applyGravity(o1);
        game.applyGravity(o2);
        assertEquals(true, (o1.getXSpeed() != 0 && o1.getYSpeed() != 0) && (o2.getXSpeed() != 0 && o2.getYSpeed() != 0));
    }
    
    //Smaller object should be removed
    @Test
    public void collisionWorks() {
        CelestialObject o1 = game.createCelestialObject("star", "sun", 0, 0, 0, 0, 1000, 100, 1);
        game.addCelestialObject(o1);
        CelestialObject o2 = game.createCelestialObject("star", "otherSun", 10, 10, 0, 0, 1000, 100, 1);
        game.addCelestialObject(o2);
        game.applyGravity(o1);
        game.removeObjectsToBeRemoved();
        assertEquals(1, game.getObjects().size());
    }
}
