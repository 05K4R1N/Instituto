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
import java.util.HashMap;

/**
 *
 * @author Oscar
 */
public class LogginBD {
    
    public HashMap authorizeUser(String username, String pass){
        HashMap<Integer, String> reference = new HashMap();
        String[] roles = {"principal", "teacher"};
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try{
            for(String rol: roles){
                String query = "SELECT id "
                            + "FROM " + rol + " "
                            + "WHERE username = ? AND password = ?";

                conn = Conexion.getInstance().getConnection();
                ptmt = conn.prepareStatement(query);
                ptmt.setString(1, username);
                ptmt.setString(2, pass);
                rs = ptmt.executeQuery();
                int id = 0;
                if(rs.next()){
                    id = rs.getInt("id");
                    reference.put(id, rol);
                }
                rs.close();
                ptmt.close();
                conn.close();
                if( id > 0 ) break;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return reference;
    }
    
    public int validateUser(int usercode){
        String[] roles          = {"principal", "teacher"};
        int res                 = 0;
        Connection conn         = null;
        PreparedStatement ptmt  = null;
        ResultSet rs            = null;
        try{
            for(String rol: roles){
                String query = "SELECT id "
                            + "FROM " + rol + " "
                            + "WHERE code = ?";
                conn = Conexion.getInstance().getConnection();
                ptmt = conn.prepareStatement(query);
                ptmt.setInt(1, usercode);
                rs = ptmt.executeQuery();
                if(rs.next()){
                    res = 1;
                }
                rs.close();
                ptmt.close();
                conn.close();
                if(res == 1) break;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
}
