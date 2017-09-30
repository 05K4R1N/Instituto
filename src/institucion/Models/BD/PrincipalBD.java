/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Models.BD;

import config.Conexion;
import institucion.Models.Users.Principal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author o5k4r1n
 */
public class PrincipalBD {
	
	public Principal getPrincipalByID(int director_id){
		Connection			conn = null;
		PreparedStatement	ptmt	= null;
		ResultSet			rs	= null;
		Principal			p = new Principal();
		
		String query = "SELECT * FROM principal where id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setInt(1, director_id);
			rs = ptmt.executeQuery();
			rs.next();
			p.setName(rs.getString("name"));
			p.setLastname(rs.getString("lastname"));
			p.setSex(rs.getString("sex"));
			p.setAddress(rs.getString("address"));
			p.setDate_of_birth(rs.getDate("date_of_birth"));
			p.setCi(rs.getInt("ci"));
			
			rs.close();
			ptmt.close();
			conn.close();
		}catch(SQLException e){
			System.out.println(e);
		}
		return p;
	}
	public boolean editPrincipalData(Principal p, int director_id){
		boolean				res		= false;
		Connection			conn	= null;
		PreparedStatement	ptmt	= null;
		ResultSet			rs		= null;
		Date principal_birthday = new Date(p.getDate_of_birth().getTime()); 
		String query = "UPDATE principal set name = ?, "
											+ "lastname = ?, "
											+ "sex = ?, "
											+ "address = ?, "
											+ "date_of_birth = ?, "
											+ "ci = ? "
					+ "WHERE id = ?";
		try{
			conn = Conexion.getInstance().getConnection();
			ptmt = conn.prepareStatement(query);
			ptmt.setString(1, p.getName());
			ptmt.setString(2, p.getLastname());
			ptmt.setString(3, p.getSex());
			ptmt.setString(4, p.getAddress());
			ptmt.setDate(5, principal_birthday);
			ptmt.setInt(6, p.getCi());
			
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
