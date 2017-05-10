/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.ceff.ict3.sdajcemanager.modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cp-14luf
 */
public class DBConnect {
    
    public static Connection connect(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch(SQLException e) {
        }
        return null;
    }
    
    public static ResultSet query(Connection connection, String query) {
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            statement.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
