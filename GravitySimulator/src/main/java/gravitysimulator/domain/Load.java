/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.domain;

import gravitysimulator.dao.CelestialObjectDao;
import gravitysimulator.database.Database;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eero
 * Load provides loading functionality
 */
public class Load {
        
    Database database;
    CelestialObjectDao celestialObjects;
    
    public Load() throws ClassNotFoundException {
        database = new Database("jdbc:sqlite:gravitysimulator.db");      
        celestialObjects = new CelestialObjectDao(database); 
    }
    
    public Load(Database db) throws ClassNotFoundException {
        database = db;      
        celestialObjects = new CelestialObjectDao(database); 
    }
    
    /**
    * loadGame loads all the objects from the database table celestialObject.
    * @return objects all the objects from the database table celestialObject
    */
    public List<CelestialObject> loadGame() throws SQLException {
        return celestialObjects.findAll();
    }
}
