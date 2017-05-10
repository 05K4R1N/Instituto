/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD.Core;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author master
 */
public class Conexion {
    String driverClassName="com.mysql.jdbc.Driver";
    String connectionUrl="jdbc:mysql://localhost/Instituto";
    String user="root";
    String password="sk@p1010";
    
    private static final Conexion _conexion=new Conexion();
    private Conexion(){
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Conexion getConnection() throws SQLException {
        Conexion conn = null;
        conn = (Conexion) DriverManager.getConnection(connectionUrl, user, password);
        return conn;
    }
    public static Conexion getInstance() {
        return _conexion;
    }

}
