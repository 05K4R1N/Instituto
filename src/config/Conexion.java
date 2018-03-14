/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author master
 */
public class Conexion {
    static String bd = "Instituto";
    static String user = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/"+bd;
    static String driver = "com.mysql.jdbc.Driver";
    
    private static final Conexion instance = new Conexion();

    private Conexion(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException{
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
    public static Conexion getInstance() {
        return instance;
    }
}
