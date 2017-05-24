/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Teacher;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author master
 */
public class TeacherBD {
    public  boolean add(Teacher t){
        boolean res = false;
        Connection conn = null;
        PreparedStatement ptmt = null;
        Date sql_date = new Date(t.getBirthday().getTime()); 
        String query = "UPDATE Teacher set first_name=?, last_name=?, birthday=?, address=?, place_birth=? WHERE id=?";
        try {
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setString(1, t.getFirst_name());
            ptmt.setString(2, t.getLast_name());
            ptmt.setDate(3, sql_date);
            ptmt.setString(4, t.getAddress());
            ptmt.setString(5, t.getPlace_birth());
            ptmt.setInt(6, 1);
            ptmt.executeUpdate();
            
            ptmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return res;
    }
    public Teacher getTeacherByID(int id){
        Teacher t = new Teacher();
        Connection conn = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Teacher WHERE id = ?";
        try {
            conn = Conexion.getInstance().getConnection();
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, id);
            rs = ptmt.executeQuery();
            rs.next();
            t.setFirst_name(rs.getString("first_name"));
            t.setLast_name(rs.getString("last_name"));
            t.setBirthday(rs.getDate("birthday"));
            t.setPlace_birth(rs.getString("place_birth"));
            t.setAddress(rs.getString("address"));
            rs.close();
            ptmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return t;
    }
}
