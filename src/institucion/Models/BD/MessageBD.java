/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Oscar
 */
public class MessageBD {
    public boolean deleteMessageByID(int messsage_id){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        String query = "DELETE FROM message where id = ?";
        try{
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, messsage_id);
            
            ptmt.executeUpdate();
            res = true;
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return res;
    }
}
