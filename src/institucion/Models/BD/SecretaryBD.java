/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Models.BD;


import config.Conexion;
import institucion.Models.Users.Secretary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author OscarT
 */
public class SecretaryBD {
    
    public Secretary getSecretary(int secretary_id){
        Secretary secretary     =   new Secretary();
        Connection conn         =   null;
        PreparedStatement ptmt  =   null;
        ResultSet rs            =   null;
        try{
            conn = Conexion.getInstance().getConnection();
            String query = "SELECT * "
                        + "FROM secretary "
                        + "WHERE id = ?";
            ptmt = conn.prepareStatement(query);
            ptmt.setInt(1, secretary_id);
            rs = ptmt.executeQuery();
            if(rs.next()){
                secretary.setFirstName(rs.getString("first_name"));
                secretary.setLastName(rs.getString("last_name"));
                secretary.setAddress(rs.getString("address"));
                secretary.setBirthday(rs.getDate("birthday"));
                secretary.setCode(rs.getInt("code"));
                secretary.setCi(rs.getInt("ci"));
                secretary.setSex(rs.getString("sex"));
                secretary.setPlace_birth(rs.getString("place_birth"));
                secretary.setPhoto(rs.getString("photo"));
                secretary.setUsername(rs.getString("username"));
                secretary.setPass(rs.getString("password"));
            }
            rs.close();
            ptmt.close();
            conn.close();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return secretary;
    }
}
