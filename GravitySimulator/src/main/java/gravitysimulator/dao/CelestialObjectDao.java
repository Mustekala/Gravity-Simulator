
package gravitysimulator.dao;

import gravitysimulator.database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import gravitysimulator.domain.CelestialObject;
import gravitysimulator.domain.Planet;
import gravitysimulator.domain.Star;

/**
 * Dao for saving the celestial objects to database 
 * @author eero
 */
public class CelestialObjectDao implements Dao<CelestialObject, Integer> {

    private final Database database;

    public CelestialObjectDao(Database database) {
        this.database = database;
    }

    /**
     * Finds all saved CelestialObjects
     * @return list of all saved CelestialObjects
     * @throws SQLException
     */
    @Override
    public List<CelestialObject> findAll() throws SQLException {
        List<CelestialObject> objects = new ArrayList<>();

        try (Connection conn = database.getConnection();
            ResultSet result = conn.prepareStatement("SELECT id, type, name, x, y, xSpeed, ySpeed, mass, size, priority FROM celestialObject").executeQuery()) {

            while (result.next()) {
                if (result.getString("type").equals("star")) {
                    objects.add(new Star(result.getInt("id"), result.getString("name"), result.getInt("x"), result.getInt("y"), result.getDouble("xSpeed"), result.getDouble("ySpeed"), result.getDouble("mass"), result.getDouble("size"), result.getInt("priority")));
                } else if (result.getString("type").equals("planet")) {
                    objects.add(new Planet(result.getInt("id"), result.getString("name"), result.getInt("x"), result.getInt("y"), result.getDouble("xSpeed"), result.getDouble("ySpeed"), result.getDouble("mass"), result.getDouble("size"), result.getInt("priority")));
                }
            }
        }

        return objects;
    }

    /**
     * Saves CelestialObjects
     * @param object the CelestialObject to be saved
     * @throws SQLException
     */
    @Override
    public void saveOrUpdate(CelestialObject object) throws SQLException {

        try (Connection conn = database.getConnection()) {
            if (object.getName() != null) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO celestialObject (type, name, x, y, xSpeed, ySpeed, mass, size, priority) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stmt.setString(1, object.getType());
                stmt.setString(2, object.getName());
                stmt.setDouble(3, object.getX());
                stmt.setDouble(4, object.getY());
                stmt.setDouble(5, object.getXSpeed());
                stmt.setDouble(6, object.getYSpeed());
                stmt.setDouble(7, object.getMass());
                stmt.setDouble(8, object.getSize());
                stmt.setDouble(9, object.getPriority());
                stmt.executeUpdate();
            }
        }

    }

    /**
     * Drops the celestialObject table
     * @throws SQLException
     */
    public void dropTable() throws SQLException {
        try (Connection conn = database.getConnection()) {
            conn.prepareStatement("DROP TABLE IF EXISTS celestialObject").executeUpdate();
        }
    }
    
    /**
     * Creates an empty table
     * @throws SQLException
     */
    public void createTable() throws SQLException {
        try (Connection conn = database.getConnection()) {
            conn.prepareStatement("CREATE TABLE celestialObject (\n" +
                                    "	id integer PRIMARY KEY,\n" +
                                    "	type varchar(10),\n" +
                                    "	name varchar(50),\n" +
                                    "	x integer,\n" +
                                    "	y integer,\n" +
                                    "	xSpeed real,\n" +
                                    "	ySpeed real,\n" +
                                    "	mass real,\n" +
                                    "	size real,\n" +
                                    "	priority integer)").executeUpdate();
        }
    }
}
