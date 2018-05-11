/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

import gravitysimulator.dao.CelestialObjectDao;
import gravitysimulator.database.Database;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eero
 * Save provides saving functionality.
 */
public class Save {
    
    Database database;
    CelestialObjectDao celestialObjects;
    
    /**
     * Class for saving the system into a SQLite database
     * @throws ClassNotFoundException
     */
    public Save() throws ClassNotFoundException {
        database = new Database("jdbc:sqlite:gravitysimulator.db");      
        celestialObjects = new CelestialObjectDao(database); 
    }
    
    /**
    * saveGame saves all the objects from the game into database.
    * @param objects all the objects from game
     * @throws java.sql.SQLException
    */
    public void saveGame(ArrayList<CelestialObject> objects) throws SQLException {
        celestialObjects.clearTable();
        celestialObjects.createTable();
        objects.forEach((object) -> {
            try {               
                celestialObjects.saveOrUpdate(object);
            } catch (SQLException ex) {
                Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
            }
        });           
    }
    
    public void clearSave() throws SQLException {
        celestialObjects.clearTable();
    }
}
