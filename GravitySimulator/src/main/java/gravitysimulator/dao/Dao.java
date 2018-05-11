/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravitysimulator.dao;

/**
 *
 * @author eero
 */
import java.sql.*;
import java.util.*;

public interface Dao<T, K> {

    List<T> findAll() throws SQLException;

    void saveOrUpdate(T object) throws SQLException;

}
