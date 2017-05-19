/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Teacher;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author master
 */
public class TeacherBD {
    public  boolean add(Teacher t){
        boolean res = false;
        Conexion con = new Conexion();
        Date sql_date = new Date(t.getBirthday().getTime()); 
        String query = "UPDATE Teacher set first_name=?, last_name=?, birthday=?, address=?, place_birth=? WHERE id=?";
        try {
            PreparedStatement ptmt = con.getConnection().prepareStatement(query);
            ptmt.setString(1, t.getFirst_name());
            ptmt.setString(2, t.getLast_name());
            ptmt.setDate(3, sql_date);
            ptmt.setString(4, t.getAddress());
            ptmt.setString(5, t.getPlace_birth());
            ptmt.setInt(6, 1);
            ptmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
}
