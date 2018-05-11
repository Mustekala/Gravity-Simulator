/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.dao;

import gravitysimulator.database.Database;
import gravitysimulator.domain.CelestialObject;
import gravitysimulator.domain.Game;
import gravitysimulator.domain.Load;
import gravitysimulator.domain.Save;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests saving functionality
 * @author eero
 */
public class SaveTest {
    Game game;
    Save save;
    Load load;
    Database database;
  
    @Before
    public void setUp() throws ClassNotFoundException {
        this.database = new Database("jdbc:sqlite:gravitysimulatorTest.db");
        game = new Game(null);
        save = new Save(database);
        load = new Load(database);
    }
    
    @After
    public void tearDown() throws SQLException {
        save.clearSave();
    }

    @Test
    public void canSaveAndLoad() throws SQLException {
        CelestialObject sun = game.createCelestialObject("star", "sun", 0, 0, 0, 0, 100, 100, 1);
        game.addCelestialObject(sun);
        CelestialObject earth = game.createCelestialObject("planet", "earth", 1000, 0, 0, 0, 10, 10, 1);
        game.addCelestialObject(earth);
        save.saveGame(game.getObjects());
        List<CelestialObject> loaded = load.loadGame();
        assertEquals(loaded.size(), game.getObjects().size());       
    }
}
