/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class LogginBD {
    
    public boolean authorizeUser(String username, String pass){
        boolean res = false;
        String[] roles = {"principal", "teacher"};
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try{
            for(String rol: roles){
                String query = "SELECT * "
                            + "FROM " + rol + " "
                            + "WHERE username = ? AND password = ?";
                conn = Conexion.getInstance().getConnection();
                ptmt = conn.prepareStatement(query);
                ptmt.setString(1, username);
                ptmt.setString(2, pass);
                rs = ptmt.executeQuery();
                if(rs.next()){
                    res = true;
                }
                rs.close();
                ptmt.close();
                conn.close();
                if(res) break;
            }
        }catch(SQLException e){
                    System.out.println(e);
        }
        return res;
    }
}
