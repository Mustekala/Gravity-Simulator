
package gravitysimulator.dao;

import gravitysimulator.database.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import gravitysimulator.domain.CelestialObject;
import gravitysimulator.domain.Planet;
import gravitysimulator.domain.Star;

public class CelestialObjectDao implements Dao<CelestialObject, Integer> {

    private final Database database;

    public CelestialObjectDao(Database database) {
        this.database = database;
    }

    @Override
    public CelestialObject findOne(Integer key) throws SQLException {
        try (Connection conn = database.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT id, type, name, x, y, xSpeed, ySpeed, mass, size, priority FROM celestialObject WHERE id = ?");
            stmt.setInt(1, key);

            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                return null;
            }

            return null;
        }
    }

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

    @Override
    public CelestialObject saveOrUpdate(CelestialObject object) throws SQLException {

        CelestialObject byName = findByName(object.getName());

        if (byName != null) {
            return byName;
        } 

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

        return findByName(object.getName());
    }

    private CelestialObject findByName(String name) throws SQLException {
        try (Connection conn = database.getConnection()) {
            //TODO
            return null;
        }
    }
    
    public void clearTable() throws SQLException {
        try (Connection conn = database.getConnection()) {
            conn.prepareStatement("DROP TABLE celestialObject").executeUpdate();
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
    
    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
