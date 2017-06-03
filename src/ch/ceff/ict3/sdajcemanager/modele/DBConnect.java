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
    
    public static Connection connect(String host, String dbName, String user, String password) {
        try {
            return DriverManager.getConnection("jdbc:mysql://"+host+":"+3306+"/"+dbName,user, password);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static ResultSet query(Statement statement, String query) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static int update(Statement statement, String query) {
        int result = -1;
        try {
            result = statement.executeUpdate(query);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static int prepareStmtUpdate(Statement statement, String query) {
        int result = -1;
        try {
            result = statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
