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
    public Object[][] getListSched(int teacher_id){
        Object[][] list_sched   =   {};
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT id, time_enter "
                        + "FROM schedule_teacher "
                        + "WHERE teacher_id = ?";
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, teacher_id);
            rs = ptmt.executeQuery();
            rs.beforeFirst();
            rs.last();
            int tam = rs.getRow();
            list_sched = new Object[tam][3];
            rs = ptmt.executeQuery();
            int i = 0;
            while(rs.next()){
                list_sched[i][0]    =   rs.getInt("id");
                list_sched[i][1]    =   rs.getString("time_enter");
                i++;
            }
            rs.close();
            ptmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return list_sched;
    }
}
