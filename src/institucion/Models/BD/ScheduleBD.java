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
import java.util.Hashtable;

/**
 *
 * @author Oscar
 */
public class ScheduleBD {
    public boolean addSchedule(int teacher_id, String time){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "INSERT INTO schedule_teacher(teacher_id, time_enter) "
                        + "VALUES (?, ?)";
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, teacher_id);
            ptmt.setString(2, time);
            
            ptmt.executeUpdate();
            res = true;
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
}
